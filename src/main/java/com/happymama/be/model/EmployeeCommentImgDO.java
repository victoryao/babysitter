package com.happymama.be.model;

import lombok.*;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCommentImgDO {
    private int id;
    private String commentId;
    private String img;
    private Date created;
}
