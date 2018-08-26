package com.happymama.be.model;

import lombok.*;

/**
 * Created by yaoqiang on 2018/3/18.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePositionDO {

    private int id;
    private int employeeId;
    private int position;
}
