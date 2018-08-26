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
public class ForumDO {
    private int id;
    private String forumId;
    private String title;
    private String content;
    private String userId;
    private Date created;
    private Date updated;
}
