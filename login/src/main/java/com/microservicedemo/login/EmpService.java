package com.microservicedemo.login;

import com.microservicedemo.login.po.Emp;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {

    /**
     *
     * 员工登录
     */
    Emp login(Emp emp);
}
