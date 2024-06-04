package com.microservicedemo.empclient.controller;

import com.microservicedemo.empclient.Client.EmpServiceClient;
import com.microservicedemo.empclient.model.Emp;
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
public class EmpServiceClientController {

    @Autowired
    private final EmpServiceClient empServiceClient;
    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByEmpId/{empId}")
    public Emp findByEmpId(@PathVariable Long empId) {
        Emp emp = empServiceClient.findByEmpId(empId);
        log.info("-------------In client  findByEmpId---------------");
        return emp;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllEmp")
    public List<Emp> findByEmpId() {
        List<Emp> empList = empServiceClient.queryAllEmp();
        log.info("--------------In client  queryAllEmp--------------");
        return empList;
    }

}
