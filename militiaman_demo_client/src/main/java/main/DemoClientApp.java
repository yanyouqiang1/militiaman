package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by helloworld on 2017/3/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class DemoClientApp {
    @Autowired
    DemoServiceImpl demoService;

    @RequestMapping("/service")
    public String getService(){
        return demoService.getService();
    }

    @RequestMapping("/")
    public String getGreed(){
        return "Client success";
    }
    public static void main(String[] args){
        SpringApplication.run(DemoClientApp.class,args);
    }
}
