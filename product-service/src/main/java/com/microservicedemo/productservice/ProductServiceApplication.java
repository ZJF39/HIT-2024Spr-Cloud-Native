package com.microservicedemo.productservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;

@ComponentScan()
@SpringBootApplication(scanBasePackages = {"com.microservicedemo.productservice.controller"})
@MapperScan(basePackages="com.microservicedemo.productservice.mapper")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
