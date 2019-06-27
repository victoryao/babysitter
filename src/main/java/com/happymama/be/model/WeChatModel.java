package com.happymama.be.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/12/17.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeChatModel {
    private String openId;
    private String nickName;
    private int sex;
    private String headImgUrl;
    private String accessToken;

}
