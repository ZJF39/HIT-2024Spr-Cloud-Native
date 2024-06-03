package com.microservicedemo.deptclient.Client;

import com.microservicedemo.deptclient.model.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */
@FeignClient(name="dept-service",fallback =DeptServiceFallback.class)
public interface DeptServiceClient {

    /**
     * 根据部门id获取部门对象
     * @param deptId
     * @return
     */
    @GetMapping("/findByDeptId/{deptId}")
    Dept findByDeptId(@RequestParam(value = "deptId") Long deptId);

    /**
     * 获取所有商品集合
     * @return
     */
    @GetMapping("queryAllDept")
    List<Dept> queryAllDept();
    @GetMapping("queryAllt")
    List<Dept> queryAl();

}
