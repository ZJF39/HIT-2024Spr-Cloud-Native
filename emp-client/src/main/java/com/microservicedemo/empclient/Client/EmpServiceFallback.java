package com.microservicedemo.empclient.Client;

import com.microservicedemo.empclient.model.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import com.microservicedemo.empservice.mapper.EmpMapper;

@Slf4j
@Component
public class EmpServiceFallback implements EmpServiceClient{

    @Override
    public Emp findByEmpId(Long empId) {
        log.info("findByEmp callback");
        return null;
    }
    @Override
    public List<Emp> queryAllEmp() {
        log.info("queryAllEmp callback");
        return null;
    }
    @Override
    public List<Emp> queryAl() {
        return null;
    }



}
