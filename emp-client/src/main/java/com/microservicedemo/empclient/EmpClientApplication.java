package com.microservicedemo.empclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.microservicedemo.empclient.controller","com.microservicedemo.empclient.Client"})
@EnableEurekaClient
@EnableFeignClients("com.microservicedemo.empclient.Client")

public class EmpClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpClientApplication.class, args);
    }
}
