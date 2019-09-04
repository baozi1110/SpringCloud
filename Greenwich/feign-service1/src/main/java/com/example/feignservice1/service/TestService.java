package com.example.feignservice1.service;

import com.example.eurekafeignapi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "hello feign---"+name;
    }

    @GetMapping("/hiyou")
    public String hiyout(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
