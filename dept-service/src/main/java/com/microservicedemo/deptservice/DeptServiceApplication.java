package com.microservicedemo.deptservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.microservicedemo.deptservice.controller"})
@MapperScan(basePackages="com.microservicedemo.deptservice.mapper")
public class DeptServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptServiceApplication.class, args);
    }

}
