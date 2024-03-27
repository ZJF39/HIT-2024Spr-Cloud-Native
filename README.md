# 哈工大2024春季学期云原生实践 微服务项目
## 注意  
  项目中product_service服务需调用主机mysql才能运行，执行前请确认本地已配置好mysql环境，并已将product_service配置文件中数据库的密码改为本机数据库密码。  
  项目中报错一般都为版本问题，笔者只能在本项目配置文件版本环境下运行成功，不能保证其他版本同样运行，如使用更新的Springboot、SpringCloud版本，请自行测试依赖库。
## 当前进度
- [x] 父项目Pom配置
- [x] Eureka注册中心
- [x] 数据库创建
- [x] 服务提供方注册
- [x] 服务使用方注册
- [x] 负载均衡
- [x] 熔断机制
- [ ] Gateway API 网关
- [ ] Config配置中心
- [ ] 云原生环境搭建……(etc)
- [ ] 容器及编排技术……(etc)
- [ ] k8s可视化界面部署
- [ ] 云原生应用自动化部署和持续集成/持续交付(CI/CD)
- [ ] 前端开发及部署……(etc)
## 环境
Maven version: 3.9.6  
JDK version: 17  
Springboot version: 2.3.9.RELEASE  
SpringCloud version: Hoxton.SR10  
## 2024.3.27更新  
### 解决上版本错误  
#### 1.Eureka启动后会在服务没有完全启动前尝试注册到自身导致日志出现报错信息，但后续服务启动成功后会重新尝试注册所以不影响最终效果。  
  尝试添加延时启动后未果，根据[CSDN外链](https://blog.csdn.net/cxyxysam/article/details/135831967?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-135831967-blog-82980717.235^v43^control&spm=1001.2101.3001.4242.1&utm_relevant_index=3 "悬停显示")所写，在Eureka服务的application.yml中添加
  ```Java
  healthcheck.enabled: false  
  onDemandUpdateStatusChange: false  
  ```  
  后，会将服务注册推迟到一次心跳时间之后（默认设置为30秒，本项目中设置为5秒，即5秒后Eureka注册到自身）  
  报错问题解决。  
#### 2.`mysql`数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。  
  经日志排查发现查找物品的命令没有发送给service，排查后发现是指导手册中提供的查找命令出错，实际命令应为：localhost:8018/findByProductId/1。  
  product-service日志接收到查找命令后再次出现报错，连接到mysql数据库时出现问题，将product_service下的application.yml中配置数据库的password: root改为自己的密码即可。  
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
