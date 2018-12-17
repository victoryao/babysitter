package com.happymama.be.enums;

/**
 * Created by yaoqiang on 2018/10/24.
 */
public enum ActivityTypEnum {

    //1:上门 0:直接支持 2：报名
    CUIRU(1, "上门催乳", 1),
    TAIPAN(2, "胎盘胶囊", 1),
    MANYUEHAN(3, "满月汗", 1),
    CUINA(4, "小儿推拿", 1),
    BAOJIE(5, "保洁", 1),
    SHEYING(7, "宝宝摄影", 0),
    WEIKE(6, "微课", 0),
    ACTIVITY(9, "活动", 2),
    BAOXIANG(8, "保险", 1);

    int type;
    String name;
    int transfer;

    ActivityTypEnum(int type, String name, int transfer) {
        this.type = type;
        this.name = name;
        this.transfer = transfer;
    }

    public static int getTransferType(int type) {
        for (ActivityTypEnum vo : ActivityTypEnum.values()) {
            if (vo.type == type) {
                return vo.transfer;
            }
        }
        return 0;
    }


}
