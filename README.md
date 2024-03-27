# 哈工大2024春季学期云原生实践 微服务项目
## 2024.3.27更新  
  ### 解决上版本错误  
1.Eureka启动后会在服务没有完全启动前尝试注册到自身导致日志出现报错信息，后续服务启动成功后会重新尝试注册所以不影响最终效果。  
 尝试添加延时启动后未果，根据[CSDN外链](https://blog.csdn.net/cxyxysam/article/details/135831967?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-135831967-blog-82980717.235^v43^control&spm=1001.2101.3001.4242.1&utm_relevant_index=3 "悬停显示")所写，在Eureka服务的application.yml中添加
  ```Java
  eureka.client.healthcheck.enabled=false  
  eureka.client.onDemandUpdateStatusChange=false  
  ```  
  后，会将服务注册推迟到一次心跳时间之后（默认设置为30秒，本项目中设置为5秒，即5秒后Eureka注册到自身）  
  报错问题解决。  
2.`mysql`数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。  
  经日志排查发现查找物品的命令没有发送给service，排查后发现是指导手册中提供的查找命令出错，实际命令应为：localhost:8018/findByProductId/1。  
  product-service日志接收到查找命令后再次出现报错，连接到mysql数据库时出现问题，将product_service下的application.yml中配置数据库的password:root改为自己的密码即可。  
  查找问题解决。  
  ### 更新信息  
  修补漏洞。  
  实现了负载均衡（product-service和product-service1轮询）  
  实现了Ribbon熔断机制（如需测试熔断机制，把product_service下的ProductController代码中的Thread.sleep(2000)注释解除即可）  
***
## 2024.3.26更新  
  ### 更新信息 
  完成了项目的`eureka`注册中心搭建、`openfeign`客户端搭建  
  实现商品_服务提供者`product-service`和商品_服务客户端`product-client`的微服务功能。  
  ### 问题  
  `mysql`数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。
