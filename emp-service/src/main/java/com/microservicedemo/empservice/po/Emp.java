package com.microservicedemo.empservice.po;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门类实体
 *
 */
@Data
public class Emp {
    private long id;
    private String username;
    private long password;
    private String name;
    private int gender;
    private int job;
    private LocalDateTime entrydate;
    private int deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
