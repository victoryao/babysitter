package com.happymama.be.service;


import com.happymama.be.dao.CustomerDao;
import com.happymama.be.model.CustomerDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    public CustomerDO addCustomer(CustomerDO customerDO) {
        CustomerDO cDo = customerDao.getCustomerByPhone(customerDO.getPhone());
        if (cDo != null) {
            return cDo;
        }
        customerDao.addCustomer(customerDO);
        return customerDO;
    }

    public CustomerDO getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public CustomerDO getCustomerByPhone(String phone) {
        return customerDao.getCustomerByPhone(phone);
    }

    public CustomerDO getCustomerByToken(String token) {
        return customerDao.getCustomerByToken(token);
    }

    public CustomerDO getCustomerByOpenId(String openId) {
        return customerDao.getCustomerByOpenId(openId);
    }


    public void updateCustomer(CustomerDO customerDO) {
        customerDao.updateCustomer(customerDO);
    }

    public void updateCustomerTokenByPhone(String mobile, String token, String openId, String img, String nickName, int sex) {
        customerDao.updateCustomerToken(mobile, token, openId, img, nickName, sex);
    }
}
