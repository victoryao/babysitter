package com.happymama.be.service;


import com.happymama.be.dao.CourseDao;
import com.happymama.be.model.CourseDO;
import com.happymama.be.model.CourseOrderDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/5/15.
 */
@Service
public class CourseService {

    @Resource
    private CourseDao courseDao;

    public CourseDO getCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    public List<CourseDO> getCourseList() {
        return courseDao.getCourseList();
    }

    public List<CourseOrderDO> getCourseOrderListByEmployeeId(int employeeId) {
        return courseDao.getCourseOrderListByEmployeeId(employeeId);
    }

}
