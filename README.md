# Microservice_Demo
# 哈工大2024春季学期云原生实践 微服务项目
***
## 2024.3.26更新  
  目前完成了项目的`eureka`注册中心搭建、`openfeign`客户端搭建  
  实现了商品_服务提供者`product-service`和商品_服务客户端`product-client`的微服务功能。  
  问题：`mysql`数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。
