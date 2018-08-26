package com.happymama.be.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopDO {
    private int id;
    private String name;
    private String address;
    private float score;
    private int comments;
    private String intro;
    private String img;
    private String descImg;
    private Date created;
    private int parentId;
    private int type;
}
