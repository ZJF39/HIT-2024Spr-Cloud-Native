package com.microservicedemo.deptclient.Client;

import com.microservicedemo.deptclient.model.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
public class DeptServiceFallback implements DeptServiceClient {
    @Override
    public Dept findByDeptId(Long deptId) {
        log.info("findByDept callback");
        return null;
    }
    @Override
    public List<Dept> queryAllDept() {
        log.info("queryAllDept callback");
        return null;
    }
    @Override
    public List<Dept> queryAl() {
        return null;
    }
}
