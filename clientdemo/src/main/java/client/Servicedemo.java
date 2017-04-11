package client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by helloworld on 2017/4/11.
 */
@FeignClient("servicedemo")
public interface Servicedemo {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getService();

    @RequestMapping(value = "/getword",method = RequestMethod.GET)
    public String getword();
}

