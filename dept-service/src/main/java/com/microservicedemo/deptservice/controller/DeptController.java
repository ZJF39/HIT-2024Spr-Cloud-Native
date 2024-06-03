package com.microservicedemo.deptservice.controller;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import com.microservicedemo.deptservice.mapper.DeptMapper;
import com.microservicedemo.deptservice.po.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品的服务控制层
 */
@AllArgsConstructor
@RestController
@Slf4j
public class DeptController {

    private final DeptMapper deptMapper;
    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByDeptId/{deptId}")
    public Dept findByDeptId(@PathVariable Long deptId)  throws InterruptedException  {
        Dept dept = deptMapper.findByDeptId(deptId);
        /*
        Thread.sleep(2000);//阻塞进程
        */
        log.info("-------------OK   /findByDeptId/{deptId}--------------------");
        return dept;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllDept")
    public List<Dept> findByDeptId() {
        List<Dept> deptList = deptMapper.queryAllDept();
        log.info("-------------OK   queryAllDept--------------------");
        return deptList;
    }

}
