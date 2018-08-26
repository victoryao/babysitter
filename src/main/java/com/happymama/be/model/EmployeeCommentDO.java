package com.happymama.be.model;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by yaoqiang on 2018/3/31.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCommentDO {
    private int id;
    private String commentId;
    private float score;
    private String comment;
    private int userId;
    private String userName;
    private int employeeId;
    private Date created;
    private String ip;
    private List<String> images;
}
