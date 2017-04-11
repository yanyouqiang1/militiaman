# militiaman
使用consul服务发现，config配置管理，rabbitmq实现消息代理，Zuul代理网关。
## consul 服务端
1、下载 consul https://www.consul.io/downloads.html	     
2、配置环境变量到目录 https://www.consul.io/intro/getting-started/install.html	     
3、简易模式启动 consul agent -dev    
## consul 客户端
1、pom 文件中添加依赖    
      spring-cloud-starter-consul-discovery
      spring-boot-starter-actuator   一般在父pom中添加
2、 bootstrap 配置文件 
spring:
   consul:
      host: consul //服务端地址，docker与之对应
      port: 8500 //端口，默认
      enabled: true
      discovery:
        enabled: true
        instance-id: gateway
        service-name: gateway
        health-check-path: /health
        health-check-interval: 10s
3、 主类文件
  加上 @EnableDiscoveryClient
## config 服务端
