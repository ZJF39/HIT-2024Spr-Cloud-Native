package com.microservicedemo.deptclient.controller;

import com.microservicedemo.deptclient.Client.DeptServiceClient;
import com.microservicedemo.deptclient.model.Dept;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class DeptServiceClientController {

    @Autowired
    private final DeptServiceClient deptServiceClient;
    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByDeptId/{deptId}")
    public Dept findByDeptId(@PathVariable Long deptId) {
        Dept dept = deptServiceClient.findByDeptId(deptId);
        log.info("-------------In client  findByDeptId---------------");
        return dept;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllDept")
    public List<Dept> findByDeptId() {
        List<Dept> deptList = deptServiceClient.queryAllDept();
        log.info("--------------In client  queryAllDept--------------");
        return deptList;
    }
}
