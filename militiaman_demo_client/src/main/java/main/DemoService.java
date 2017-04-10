package main;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by helloworld on 2017/3/26.
 */
@FeignClient("service2")
public interface DemoService {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getService();
}
