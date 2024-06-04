package com.microservicedemo.empservice.controller;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import com.microservicedemo.empservice.mapper.EmpMapper;
import com.microservicedemo.empservice.po.Emp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工表的服务控制层
 */
@AllArgsConstructor
@RestController
@Slf4j
public class EmpController {

    private final EmpMapper empMapper;
    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByEmpId/{empId}")
    public Emp findByEmpId(@PathVariable Long empId)  throws InterruptedException  {
        Emp emp = empMapper.findByEmpId(empId);
        /*
        Thread.sleep(2000);//阻塞进程
        */
        log.info("-------------OK   /findByEmpId/{empId}--------------------");
        return emp;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllEmp")
    public List<Emp> findByEmpId() {
        List<Emp> empList = empMapper.queryAllEmp();
        log.info("-------------OK   queryAllEmp--------------------");
        return empList;
    }



}
