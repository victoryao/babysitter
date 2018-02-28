package entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by yaoqiang on 2018/2/27.
 */
@Builder
@Data
public class BabySitterDO {

    private String name;
    private String phone;
    private int babyAge;
    private String address;
    private String memo;
    private Date created;
    private Date updated;
}
