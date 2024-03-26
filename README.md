# Microservice_Demo
哈工大2024春季学期云原生实践 微服务项目
2024.3.26
目前完成了项目的eureka注册中心搭建、openfeign客户端搭建
实现了 商品_服务提供者 和 商品_服务客户端 的微服务功能。
问题：mysql数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。
