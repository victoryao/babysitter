package com.happymama.be.service;


import com.happymama.be.dao.OrderDao;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.OrderDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private CustomerService customerService;

    public long getOrderCount() {
        return orderDao.getOrderCount();
    }

    public boolean addOrder(String name, String phone, String address, int type, String memo) {

        //客户逻辑处理
        CustomerDO customerDO = CustomerDO.builder().name(name).phone(phone).address(address).build();
        customerDO = customerService.addCustomer(customerDO);

        OrderDO orderDO = OrderDO.builder().employeeId(0).customerId(customerDO.getId()).price(0).type(type).status(0)
                .memo(memo).realPrice(0).recommendPrice(0).build();
        orderDao.addOrder(orderDO);

        return true;
    }

}
