package com.microservicedemo.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient// 启动 eureka 客户端
@EnableConfigServer// 启动 config 服务端
public class ConfigServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConfigServiceApplication.class, args);
	}

}
