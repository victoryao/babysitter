package com.happymama.be.sms;

import com.happymama.be.enums.OperatorEnum;

/**
 * Created by yaoqiang on 2018/6/30.
 */
public interface ISmsChannel {
    OperatorEnum type();

    boolean send(String mobile, String content);


}
