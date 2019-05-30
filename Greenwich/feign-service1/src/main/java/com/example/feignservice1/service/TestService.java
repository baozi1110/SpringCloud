package com.example.feignservice1.service;

import com.example.eurekafeignapi.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "hello feign---"+name;
    }
}
