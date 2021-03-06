package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.model.CourseOrderDO;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.EmployeeCommentDO;
import com.happymama.be.model.EmployeeDO;
import com.happymama.be.service.CourseService;
import com.happymama.be.service.EmployeeCommentService;
import com.happymama.be.service.EmployeeService;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import com.happymama.be.utils.Utils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/7/22.
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private CourseService courseService;
    @Resource
    private EmployeeCommentService employeeCommentService;


    @RequestMapping("/employee/list")
    public String toEmployeeListPage(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "") String types,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "1") int page,
            ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<EmployeeDO> pageView = new PageView<>(limit, page);
        name = StringUtils.isBlank(name) ? null : name;
        phone = StringUtils.isBlank(phone) ? null : phone;
        types = StringUtils.isBlank(types) ? null : types;
        QueryResult<EmployeeDO> qr = employeeService.getEmployeeList(name, phone, types, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("phone", phone);
        modelMap.addAttribute("types", types);
        return "/employee/list";
    }

    @RequestMapping("/employee/{id}/detail")
    public String toEmployeeDetailPage(
            @PathVariable int id,
            ModelMap modelMap) {
        List<Integer> positionList = employeeService.getPositionListByEmployeeId(id);
        String types = "";
        if (!org.springframework.util.CollectionUtils.isEmpty(positionList)) {
            for (int position : positionList) {
                types += position + ",";
            }
        }

        EmployeeDO employeeDO = employeeService.getEmployeeById(id);

        List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(id);
        assembleRecommendInfo(courseOrderDOs);
        employeeDO.setTypes(types);

        //月嫂评论
        QueryResult<EmployeeCommentDO> comments = employeeCommentService.getCommentListByEmployeeId(id, 0, 3);

        modelMap.addAttribute("commentCount", comments.getTotalrecord());
        modelMap.addAttribute("courseOrders", courseOrderDOs);
        modelMap.addAttribute("employeeDO", employeeDO);
        modelMap.addAttribute("employeeComments", comments);
        return "/employee/detail";
    }

    private void assembleRecommendInfo(List<CourseOrderDO> courseOrderDOs) {
        if (CollectionUtils.isNotEmpty(courseOrderDOs)) {
            for (CourseOrderDO orderDO : courseOrderDOs) {
                orderDO.setCourseName(courseService.getCourseById(orderDO.getCourseId()).getName());
            }
        }
    }

}
