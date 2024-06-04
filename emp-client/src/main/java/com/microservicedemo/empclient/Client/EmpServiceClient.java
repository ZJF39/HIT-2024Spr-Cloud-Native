package com.microservicedemo.empclient.Client;

import com.microservicedemo.empclient.model.Emp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */
@FeignClient(name="emp-service",fallback =EmpServiceFallback.class)
public interface EmpServiceClient {

    /**
     * 根据部门id获取部门对象
     * @param empId
     * @return
     */
    @GetMapping("/findByEmpId/{EmpId}")
    Emp findByEmpId(@RequestParam(value = "empId") Long empId);

    /**
     * 获取所有商品集合
     * @return
     */
    @GetMapping("queryAllEmp")
    List<Emp> queryAllEmp();
    @GetMapping("queryAllt")
    List<Emp> queryAl();
}
