package com.springcloud.feignclient1.controller;

import com.example.eurekafeignapi.entity.User;
import com.springcloud.feignclient1.service.HelloServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHelloController {
    @Autowired
    private HelloServiceClient helloServiceClient;

    @GetMapping("/test")
    public String test(String name) {
        return helloServiceClient.hello(name);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String helloUser(User user){
        return helloServiceClient.helloUser(user);
    }
}
