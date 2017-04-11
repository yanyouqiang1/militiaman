import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by helloworld on 2017/4/11.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {
    @RequestMapping("/")
    public String home() {
        return "serviceDemo success!!!!!!!!";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);
    }

}
