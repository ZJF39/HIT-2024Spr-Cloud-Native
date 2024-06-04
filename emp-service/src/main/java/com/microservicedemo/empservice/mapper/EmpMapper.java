package com.microservicedemo.empservice.mapper;

import com.microservicedemo.empservice.po.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.time.LocalDateTime;

import java.util.List;
public interface EmpMapper {

    @Select("select id, username, password, name, gender, job, entrydate,"+" dept_id deptId, create_time createTime, update_time updateTime from emp e where id = #{empId}")
    Emp findByEmpId(@Param("empId") Long id);

    @Select("select id, username, password, name, gender, job, entrydate,"+" dept_id deptId, create_time createTime, update_time updateTime  from emp e")
    List<Emp> queryAllEmp();


}
