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
public class TopicDO {
    private int id;
    private String name;
    private String img;
    private Date created;
    private int parentId;
}
