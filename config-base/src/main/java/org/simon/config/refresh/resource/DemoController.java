package org.simon.config.refresh.resource;

import org.simon.config.refresh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RefreshScope
@RestController
@RequestMapping("/")
public class DemoController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${system.order.serverName:default}")
    private String serverName;


    @Value("${test.key01}")
    private String testKey;

    @Autowired
    private TestService testService;

    public DemoController(){
        System.out.println("************");
    }



    @RequestMapping("/test")
    public String test(String user) {
        return "port:" + port + ",serverName:" + serverName;
    }

    @RequestMapping("/testKey01")
    public String testKey01() {
        return testKey;
    }

    private AtomicLong counter = new AtomicLong(1);

    public String getServerName() {
        return serverName;
    }
}
