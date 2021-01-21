package org.simon.config.refresh.resource;

import org.simon.config.refresh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class DemoController02 {

    @Autowired
    private DemoController demoController;

    @Autowired
    private TestService testService;

    public DemoController02(){
        System.out.println("************");
    }



    @RequestMapping("/test2")
    public String test(String user) {
        return demoController.getServerName();
    }

    private AtomicLong counter = new AtomicLong(1);

}
