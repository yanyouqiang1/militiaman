package client;

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
 * Created by helloworld on 2017/4/11.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class ClientApplication {
    @Autowired
    ServicedemoImpl service;

    @RequestMapping("/service")
    public String getService() {
        return service.getService();
    }

    @RequestMapping("/")
    public String getGreed() {
        return "Client success";
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
