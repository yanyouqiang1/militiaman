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
1、在GitHub上创建放置配置文件的仓库 如本项目 https://github.com/yanyouqiang1/militiamanConfig
2、pom 添加    spring-cloud-config-server  spring-cloud-starter
3、bootstrap.yml  
server:
  port: 8080     //端口号

spring:
  application:
    name: configServer

  cloud:
    config:
      server:
        git:
          uri: https://github.com/yanyouqiang1/militiamanConfig //GitHub地址
          search-paths: //扫描文件夹
          - data
4、主类   
@EnableConfigServer

## config 客户端
1、pom添加    spring-cloud-starter-config
2、bootstrap
spring：
  cloud:
    config:
        uri: http://configServer:8080 //docker实际布置过程中，出现问题。
        name: clientdemo
3、主类
@Value("${word}") String word;    //获取配置文件中的值

## spring cloud bus实现 rabbitmq代理  服务端
下载运行
docker中部署运行
## rabbitmq 客户端
1、pom
  spring-cloud-starter-bus-amqp
2、配置文件
spring：
  rabbitmq:
    host: rabbitmq  //与docker对应
    port: 5672    //默认的端口，与服务对应
    username: user //服务端的用户
    password: password  //密码
3、主类
无
## 部署自己的服务可能用到（Feign负载均衡，Hystrix熔断器）
### Feign 使用
1、pom
spring-cloud-starter-feign
2、配置文件
无
3、建立接口 Servicedemo
@FeignClient("servicedemo")   //与服务注册时的名字一致，接口中的方法为本实例需要用到的服务接口
public interface Servicedemo {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getService();

    @RequestMapping(value = "/getword",method = RequestMethod.GET)
    public String getword();
}
4、主类
@AutoWire
ServiceDome service; //用自动注入调用服务
### Hystrix 使用
1、pom
spring-cloud-starter-hystrix
2、配置文件
无
3、在Feign接口的基础上，添加新的类ServicedemoImpl 实现Servicedome接口
@Service
public class ServicedemoImpl implements Servicedemo {
    @Autowired
    private Servicedemo demoService;

    @Override
    @HystrixCommand(fallbackMethod = "servicefallback")  //服务响应时间长，或者其他原因，则启用断路器，调用servicefallback方法
    public String getService() {
        return demoService.getService();
    }
    public String servicefallback(){
        return "hystrix success!";
    }


    @Override
    @HystrixCommand(fallbackMethod = "getwordfallback")
    public String getword() {
        return demoService.getword();
    }
    public String getwordfallback(){
        return "get word fail";
    }
}





