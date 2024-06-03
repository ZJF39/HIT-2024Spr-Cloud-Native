package com.microservicedemo.deptclient.model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门类实体
 *
 */
@Data
public class Dept {
    private Long id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
