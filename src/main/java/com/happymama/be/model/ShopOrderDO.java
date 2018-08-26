package com.happymama.be.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/7/26.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrderDO {
    private int id;
    private int activityId;
    private int customerId;
    private String mobile;
    private float price;
    private float realPrice;
    private String code;
    private String memo;
    private int type;
    private int status;
    private Date created;
    private Date updated;
}
