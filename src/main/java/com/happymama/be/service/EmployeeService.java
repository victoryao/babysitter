package com.happymama.be.service;

import com.happymama.be.dao.EmployeeDao;
import com.happymama.be.dao.EmployeePositionDao;
import com.happymama.be.model.CourseOrderDO;
import com.happymama.be.model.EmployeeDO;
import com.happymama.be.model.EmployeePhotoDO;
import com.happymama.be.utils.QueryResult;
import lombok.extern.java.Log;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Service
@Log
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private CourseService courseService;
    @Resource
    private EmployeePositionDao employeePositionDao;

    public List<String> getEmployeePhotoList(@Param("employeeId") int employeeId, @Param("type") int type) {
        return employeeDao.getEmployeePhotoList(employeeId, type);
    }
    public EmployeeDO getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public QueryResult<EmployeeDO> getEmployeeList(String name, String phone, String types, int offset, int limit) {
        QueryResult<EmployeeDO> qr = new QueryResult<>();
        List<EmployeeDO> list = employeeDao.getEmployeeList(name, phone, types, offset, limit);
        if (CollectionUtils.isNotEmpty(list)) {
            for (EmployeeDO employeeDO : list) {
                List<CourseOrderDO> courseOrderDOs = courseService.getCourseOrderListByEmployeeId(employeeDO.getId());
                if (CollectionUtils.isNotEmpty(courseOrderDOs)) {
                    for (CourseOrderDO courseOrderDO : courseOrderDOs) {
                        courseOrderDO.setCourseName(courseService.getCourseById(courseOrderDO.getCourseId()).getName());
                    }
                }
                employeeDO.setCourseOrderDOs(courseOrderDOs);
            }
        }
        long count = getEmployeeCount(name, phone, types);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getEmployeeCount(String name, String phone, String types) {
        return employeeDao.getEmployeeCount(name, phone, types);
    }

    public List<EmployeeDO> getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    public List<Integer> getPositionListByEmployeeId(int employeeId) {
        return employeePositionDao.getPositionListByEmployeeId(employeeId);
    }

    public void updateEmployeeScore(float score, int employeeId) {
        employeeDao.updateEmployeeScore(score, employeeId);
    }

}
