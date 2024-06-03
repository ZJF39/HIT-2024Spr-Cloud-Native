package com.microservicedemo.deptclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.microservicedemo.deptclient.controller","com.microservicedemo.deptclient.Client"})
@EnableEurekaClient
@EnableFeignClients("com.microservicedemo.deptclient.Client")

public class DeptClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptClientApplication.class, args);
    }
}
