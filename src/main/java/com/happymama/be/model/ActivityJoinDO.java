package com.happymama.be.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/12/17.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJoinDO {
    private int id;
    private int activityId;
    private int userId;
    private Date created;
}
