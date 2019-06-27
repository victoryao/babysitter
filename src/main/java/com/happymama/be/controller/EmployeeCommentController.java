package com.happymama.be.controller;

import com.happymama.be.exception.AesException;
import com.happymama.be.model.*;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.service.*;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import com.happymama.be.utils.SHA1;
import com.happymama.be.utils.Utils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yaoqiang on 2018/7/31.
 */
@Controller
public class EmployeeCommentController {

    @Resource
    private CustomerService customerService;
    @Resource
    private EmployeeCommentService employeeCommentService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private CourseService courseService;
    @Resource
    private WechatService wechatService;

    @RequestMapping("/employee/{employeeId}/to/comment/add")
    public String toAddEmployeeCommentPage(@PathVariable int employeeId,
                                           @RequestParam String accessToken,
                                           HttpServletRequest request,
                                           ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken) || "undefined".equals(accessToken)) {
            return "/my/login";
        }
        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }
        modelMap.addAttribute("employeeId", employeeId);
        modelMap.addAttribute("commentId", Utils.getId());
        modelMap.addAttribute("contextPath", request.getContextPath());
        return "/employee/comment";
    }

    @RequestMapping("/employee/addComment")
    public String addEmployeeComment(@RequestParam String commentId,
                                     @RequestParam int employeeId,
                                     @RequestParam(required = false, defaultValue = "5") int score,
                                     @RequestParam String content,
                                     @RequestParam String accessToken,
                                     HttpServletRequest request,
                                     @RequestParam(required = false, defaultValue = "") String from,
                                     ModelMap modelMap) throws AesException {

        if (StringUtils.isBlank(accessToken) || "undefined".equals(accessToken)) {
            return "/my/login";
        }
        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }


        String ts = String.valueOf(System.currentTimeMillis() / 1000);
        String nonce = String.valueOf(System.currentTimeMillis());

        String jsApiTicket = wechatService.getJsapiTicket(wechatService.getAccessToken());

        String url = "http://newmami.cn/app/employee/addComment.do";
        if (StringUtils.isNotBlank(from)) {
            url += "?from=" + from;
        }

        String sign = SHA1.getSHA1("jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonce + "&timestamp=" + ts + "&url=" + url);

        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts)
                .nonceStr(nonce).paySign(sign).build();

        modelMap.addAttribute("pay", pay);


        String ip = Utils.getIpAddr(request);
        employeeCommentService.addEmployeeComment(EmployeeCommentDO.builder().commentId(commentId).comment(content)
                .score(score).employeeId(employeeId).userId(customerDO.getId()).ip(ip).build());


        employeeService.updateEmployeeScore(employeeCommentService.getEmployeeScoreByEmployeeId(employeeId), employeeId);

        List<Integer> positionList = employeeService.getPositionListByEmployeeId(employeeId);
        String types = "";
        if (!org.springframework.util.CollectionUtils.isEmpty(positionList)) {
            for (int position : positionList) {
                types += position + ",";
            }
        }

        EmployeeDO employeeDO = employeeService.getEmployeeById(employeeId);
        List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(employeeId);
        assembleRecommendInfo(courseOrderDOs);
        employeeDO.setTypes(types);

        //月嫂评论
        QueryResult<EmployeeCommentDO> comments = employeeCommentService.getCommentListByEmployeeId(employeeId, 0, 3);

        modelMap.addAttribute("employeeComments", comments);
        modelMap.addAttribute("employeeId", employeeId);
        modelMap.addAttribute("courseOrders", courseOrderDOs);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/employee/detail";
    }


    @RequestMapping("/employee/comment/list")
    public String getEmployeeCommentList(
            @RequestParam int employeeId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "1") int page,
            ModelMap modelMap) {

        EmployeeDO employeeDO = employeeService.getEmployeeById(employeeId);
        PageView<EmployeeCommentDO> pageView = new PageView<>(limit, page);

        QueryResult<EmployeeCommentDO> qr = employeeCommentService.getCommentListByEmployeeId(employeeId, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("employeeId", employeeId);
        modelMap.addAttribute("employeeDO", employeeDO);
        return "/employee/comment_list";
    }


    private void assembleRecommendInfo(List<CourseOrderDO> courseOrderDOs) {
        if (CollectionUtils.isNotEmpty(courseOrderDOs)) {
            for (CourseOrderDO orderDO : courseOrderDOs) {
                orderDO.setCourseName(courseService.getCourseById(orderDO.getCourseId()).getName());
            }
        }
    }

}
