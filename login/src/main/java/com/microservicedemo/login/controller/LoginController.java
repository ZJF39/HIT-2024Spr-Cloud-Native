package com.microservicedemo.login.controller;

import com.microservicedemo.login.EmpService;
import com.microservicedemo.login.po.Emp;
import com.microservicedemo.login.po.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e = empService.login(emp);
        return e !=null?Result.success():Result.error("用户名或密码错误");
    }
}
