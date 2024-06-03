package com.microservicedemo.deptservice.mapper;

import com.microservicedemo.deptservice.po.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.time.LocalDateTime;

import java.util.List;

public interface DeptMapper {

    @Select("select id, name,"+" create_time createTime, update_time updateTime from dept d where id = #{deptId}")
    Dept findByDeptId(@Param("deptId") Long id);

    @Select("select id, name,"+ " create_time createTime, update_time updateTime from dept d")
    List<Dept> queryAllDept();

}
