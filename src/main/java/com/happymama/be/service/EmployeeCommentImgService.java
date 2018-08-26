package com.happymama.be.service;

import com.happymama.be.dao.EmployeeCommentImgDao;
import com.happymama.be.model.EmployeeCommentImgDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/3.
 */
@Service
public class EmployeeCommentImgService {

    @Resource
    private EmployeeCommentImgDao employeeCommentImgDao;

    public boolean addEmployeeCommentImg(EmployeeCommentImgDO employeeCommentImgDO) {
        return employeeCommentImgDao.addEmployeeCommentImg(employeeCommentImgDO);
    }

    public List<String> getEmployeeCommentImgByCommentId(String commentId) {
        return employeeCommentImgDao.getEmployeeCommentImgByCommentId(commentId);
    }

}
