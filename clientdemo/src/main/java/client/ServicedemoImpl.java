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


    @Override
    @HystrixCommand(fallbackMethod = "getwordfallback")
    public String getword() {
        return demoService.getword();
    }
    public String getwordfallback(){
        return "get word fail";
    }

    @Override
    @HystrixCommand(fallbackMethod = "getipfallback")
    public String getIP() {
        return demoService.getIP();
    }
    public String getipfallback(){
        return "get ip fail";
    }
}
