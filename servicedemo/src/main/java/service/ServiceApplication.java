package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by helloworld on 2017/4/11.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ServiceApplication {
    @RequestMapping("/")
    public String home() {
        return "serviceDemo success!!!!!!!!";
    }

    @Value("${wordConfig.word}") String word;
    @RequestMapping("/getword")
    public String getWord() {
        return word;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);
    }


}
