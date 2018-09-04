package com.happymama.be.enums;

/**
 * Created by yaoqiang on 2018/8/30.
 */
public enum PayStatusEnum {

    NOTPAY(0),
    PAIED(1),
    CONSUMED(2);

    int value;

    PayStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
