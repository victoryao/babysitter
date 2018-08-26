package com.happymama.be.service;

import com.google.common.collect.Lists;
import com.happymama.be.dao.EmployeeCommentDao;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.EmployeeCommentDO;
import com.happymama.be.utils.QueryResult;
import com.happymama.be.utils.Utils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/3.
 */
@Service
public class EmployeeCommentService {

    @Resource
    private EmployeeCommentDao employeeCommentDao;
    @Resource
    private EmployeeCommentImgService employeeCommentImgService;
    @Resource
    private CustomerService customerService;

    public boolean addEmployeeComment(EmployeeCommentDO employeeCommentDO) {
        return employeeCommentDao.addEmployeeComment(employeeCommentDO);
    }

    public float getEmployeeScoreByEmployeeId(int employeeId) {
        return Math.round(employeeCommentDao.getEmployeeScoreByEmployeeId(employeeId));
    }

    public QueryResult<EmployeeCommentDO> getCommentListByEmployeeId(int employeeId, int firstResult, int maxresult) {
        QueryResult<EmployeeCommentDO> qr = new QueryResult<>();
        List<EmployeeCommentDO> list = employeeCommentDao.getCommentListByEmployeeId(employeeId, firstResult, maxresult);

        if (CollectionUtils.isNotEmpty(list)) {
            for (EmployeeCommentDO employeeCommentDO : list) {
                List<String> imgs = employeeCommentImgService.getEmployeeCommentImgByCommentId(employeeCommentDO.getCommentId());
                CustomerDO customerDO = customerService.getCustomerById(employeeCommentDO.getUserId());
                if (customerDO != null) {
                    employeeCommentDO.setUserName(Utils.secureName(customerDO.getPhone()));
                }
                employeeCommentDO.setImages(imgs == null ? Lists.newArrayList() : imgs);
            }
        }

        long count = getCommentCountByEmployeeId(employeeId);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getCommentCountByEmployeeId(int employeeId) {
        return employeeCommentDao.getCommentCountByEmployeeId(employeeId);
    }

}
