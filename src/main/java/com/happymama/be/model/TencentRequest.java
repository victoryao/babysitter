package com.happymama.be.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaoqiang on 2018/6/30.
 */
@Data
public class TencentRequest implements Serializable {
    private static final long serialVersionUID = 3247785001625005246L;

    private Tel tel;

    private int type;

    private String msg;

    private String sig;

    private long time;

    private String extend;

    private String ext;

    @Data
    public static class Tel implements Serializable {
        private static final long serialVersionUID = 7393287717665913216L;

        public Tel(String nationcode, String mobile) {
            this.nationcode = nationcode;
            this.mobile = mobile;
        }

        private String nationcode;

        private String mobile;
    }
}
