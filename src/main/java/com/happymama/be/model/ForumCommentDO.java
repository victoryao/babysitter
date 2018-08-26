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
public class ForumCommentDO {
    private int id;
    private int forumId;
    private String content;
    private int userId;
    private String userName;
    private Date created;
    private Date updated;
}
