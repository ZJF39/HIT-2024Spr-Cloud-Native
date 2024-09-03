# 哈工大2024春季学期云原生实践 微服务项目  
项目展示见：https://zjf39.github.io/  
## 声明
  在写这个项目的时候本人连Spring是什么都不了解，Java也才刚刚开始看，所以本项目基本就是东拼西凑照猫画虎写出来的四不像，说是微服务但是其实项目结构非常诡异而且业务代码不具参考价值。  
  但是作为写出来第一个能运行的完整（？）项目还是姑且保留了。  
  后续搜到本项目的人建议不要使用本项目，后续会对项目进行翻新并构建成一个新的完整的项目。  
  书于2024.8.6  
## 注意  
  项目中 __product_service__ 服务需调用主机mysql才能运行，执行前请确认 __本地已配置好mysql环境__ ，并已将product_service配置文件中 __数据库的密码改为本机数据库密码__ 。  
  项目中 __报错一般都为版本问题__ ，笔者只能在本项目配置文件版本环境下运行成功，不能保证其他版本同样运行，如使用更新的Springboot、SpringCloud版本，请自行测试依赖库。  
  项目中 __Config配置中心的远程仓库需要单独配置__ ，笔者的仓库随时可能会进行变动，未更改直接启动可能会产生错误。  
  项目中的config-service会调用远程仓库的配置文件，但如果该服务未启动，product-service就会调用本地application.yml而非bootstrap.yml（bootstrap优先级最高）进行配置。在测试项目的负载均衡时会通过Copy configuration的方法复制多个product-service服务并分别赋予不同的端口，但若通过config配置中心进行集中配置的话，会因为争用端口导致只有一个product-service服务可以启动成功（即不能通过vm option赋予不同的端口），如需在后续的操作中测试product-service的负载均衡功能或需要启动多个服务，请关闭config-service，改用本地配置文件进行配置即可。  
## 当前进度
- [x] 父项目Pom配置
- [x] Eureka注册中心
- [x] 数据库创建
- [x] 服务提供方注册
- [x] 服务使用方注册
- [x] 负载均衡
- [x] 熔断机制
- [x] Gateway API 网关
- [x] Config配置中心
- [x] 云原生环境搭建
- [x] 容器及编排技术
- [x] k8s可视化界面部署
- [x] 云原生应用自动化部署和持续集成/持续交付(CI/CD)
- [x] 前端开发及部署……(etc)
## 环境
Maven version: 3.9.6  
JDK version: 17  
Springboot version: 2.3.9.RELEASE  
SpringCloud version: Hoxton.SR10  
## 2024.6.6更新
实现了``云原生应用的自动化CI/CD持续集成持续交付`` ``前端开发及部署``  
学校要求的项目内容已全部完成。  
项目历时三个月，终于在6月5日顺利验收，从最开始面临很多新技术时的不知所措到最后能独立编写jenkins脚本和部署配置文件，真的学到了很多东西。  
由于项目主要是在云环境下部署实现的，这一部分内容全部在本地的虚拟机上运行，没办法将环境上传到github上，后续有时间的话我会来写一下云环境(虚拟机)搭建过程(有时间的话)。  
目前github仓库中是部署在云环境下服务的所有内容，但因个人水平原因(只是java初学者)只实现了增删改查中的查询功能，登录只是简单的在数据库中查找，没有实现cookie和jwt令牌，后续有时间的话会回来完善这部分内容的，目标是最终能完成一个完整的项目并且部署到真正的云服务器上吧。  
本仓库中各服务配置文件分为k8s虚拟机用和Windows宿主机用两部分，请在main文件夹下的resource文件夹中自行调整。k8s文件夹中为项目的部署配置文件，请在部署前更改仓库地址。
感谢郭勇老师，对我的问题有问必答，解决不了的问题还帮我远程调试。 
结项愉快！  
## 2024.5.22更新  
实现了``云原生环境搭建`` ``容器及编排技术`` ``k8s可视化界面部署``  
内容部署在虚拟机上，前述版本全部转移进Old_version文件夹内  
目前项目中代码不能直接运行，需要配置到云原生环境中  
## 2024.3.29更新  
### 更新信息
实现了``Gateway API网关``和全局过滤器。可通过网关实现将请求路由到其所需的服务上，并且具有负载均衡功能（实现方式与之前不同）。同时在网关上实现了统一鉴权的全局过滤器配置，请求参数中需包含token参数，且过滤器中只放行token为1的请求。  
实现了``Config配置中心``。将product-service服务的配置文件配置在[仓库](https://github.com/2023120260/serviceconfig "悬停显示")中，并在项目中创建Config-service提供配置服务，product-service可通过该服务连接到远程仓库，实现微服务的集中配置管理和运行期间动态调整。
***
## 2024.3.27更新  
### 解决错误  
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
  实现了``负载均衡``（product-service和product-service1轮询）  
  实现了``Ribbon熔断机制``（如需测试熔断机制，把product_service下的ProductController代码中的Thread.sleep(2000)注释解除即可）  
***
## 2024.3.26更新  
### 更新信息 
  完成了项目的`eureka`注册中心搭建、`openfeign`客户端搭建  
  实现商品_服务提供者`product-service`和商品_服务客户端`product-client`的微服务功能。  
  ### 问题  
  `mysql`数据库没有与product-service连接起来，导致product-client在调用服务时查找不到物品ID。
