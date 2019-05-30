package com.springcloud.feignclient1.controller;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.feignclient1.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestController
@RequestMapping("/httpClient")
public class TestHttpClientController {

    @RequestMapping(value = "/testPost", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addHouseType(@RequestBody User user, ServletRequest request, ServletResponse response) {
        return user.getName()+"住在"+user.getAddress();
    }
}
