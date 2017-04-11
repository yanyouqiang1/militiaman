package client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by helloworld on 2017/4/11.
 */
@Service
public class ServicedemoImpl implements Servicedemo {

    @Autowired
    private Servicedemo demoService;

    @Override
    @HystrixCommand(fallbackMethod = "servicefallback")
    public String getService() {
        return demoService.getService();
    }
    public String servicefallback(){
        return "hystrix success!";
    }
}
