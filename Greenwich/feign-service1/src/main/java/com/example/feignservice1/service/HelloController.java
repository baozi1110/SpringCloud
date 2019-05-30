package com.example.feignservice1.service;

import com.example.eurekafeignapi.entity.User;
import com.example.eurekafeignapi.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloService {
    @Override
    public String hello(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello 继承:"+name;
    }

    @Override
    public String helloUser(User user) {
        return "hello"+user.getName()+"..."+user.getAddress();
    }

}
