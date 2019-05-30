package com.example.eurekafeignapi.service;

import com.example.eurekafeignapi.entity.User;
import org.springframework.web.bind.annotation.*;

public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/helloUser", method= RequestMethod.POST)
    String helloUser(@RequestBody User user);

}
