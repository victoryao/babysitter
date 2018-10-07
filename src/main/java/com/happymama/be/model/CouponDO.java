package com.happymama.be.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/5/15.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponDO {
    private int id;
    private String mobile;
    private int activityId;
    private int price;
    private int status;
}
