package com.happymama.be.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/8/24.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayModel {
    private String appId;
    private String timeStamp;
    private String nonceStr;
    private String packages;
    private String signType;
    private String paySign;
}
