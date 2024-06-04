package com.microservicedemo.empservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.microservicedemo.empservice.controller"})
@MapperScan(basePackages="com.microservicedemo.empservice.mapper")

public class EmpServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpServiceApplication.class, args);
    }
}