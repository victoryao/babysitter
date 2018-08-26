package com.happymama.be.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/8/25.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WXOpenIdModel {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
}
