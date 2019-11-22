package com.example.oauth2client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Baozi
 */
@RestController
public class UserInfoDemo {

    @GetMapping(value = "/user")
    @ResponseBody
    public String getUserInfo(){
        return "userInfo";
    }
}
