package com.qp.ribbonconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloService() {
        long start = System.currentTimeMillis();
        String body = restTemplate.getForEntity("http://eureka-client/dc", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time : " + (end - start));
        return body.toString();
    }

    public String helloFallback() {
        return "error";
    }
}
