package com.happymama.be.enums;

/**
 * Created by yaoqiang on 2018/11/6.
 */
public enum  ActivityParentEnum {

    PARENT(1),
    CHILD(0);

    int type;

    ActivityParentEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
