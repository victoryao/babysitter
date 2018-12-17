package com.happymama.be.model;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopActivityDO {
    private int id;
    private String name;
    private String img;
    private int shopId;
    private int price;
    private int type;
    private float discount;
    private int realPrice;
    private int parentId;
    private int isParent;
    private String desc;
    private String phone;
    private String tab;
    private Date startDate;
    private Date endDate;
    private Date created;
    private ShopDO shopDO;
    List<String> images;
}
