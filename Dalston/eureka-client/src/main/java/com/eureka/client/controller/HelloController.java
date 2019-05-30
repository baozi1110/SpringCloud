package com.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/dc")
    public String dc(){
        // String services = "Services:"+discoveryClient.getServices();
        // System.out.println(services);
        System.out.println("hello");
        return "hello";
    }

    /**
     * 通过模拟服务阻塞，验证断路器hystrix作用
     */
    // @GetMapping("/dc")
    // public String dc() throws InterruptedException {
    //     ServiceInstance instance = discoveryClient.getLocalServiceInstance();
    //     // 让处理线程等待几秒钟
    //     int sleepTime = new Random().nextInt(3000);
    //     logger.info("sleepTime:"+sleepTime);
    //     Thread.sleep(sleepTime);
    //     logger.info("/hello, host:" + instance.getHost() + ", service id:" + instance.getServiceId());
    //     return "Hello World";
    // }
}
