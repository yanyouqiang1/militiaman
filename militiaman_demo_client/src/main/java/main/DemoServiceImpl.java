package main;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import main.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by helloworld on 2017/3/26.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoService demoService;

    @Override
    @HystrixCommand(fallbackMethod = "getServiceback")
    public String getService() {
        return demoService.getService();
    }
    public String getServiceback(){
        return "hystrix success!";
    }


}
