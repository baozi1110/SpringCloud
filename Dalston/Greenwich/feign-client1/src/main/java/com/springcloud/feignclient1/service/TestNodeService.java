// package com.springcloud.feignclient1.service;
//
// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
//
// @FeignClient(name = "feign-service1")
// public interface TestNodeService {
//     // 这里要填加@RequestParam
//     @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
//     String hello(@RequestParam("name") String name);
// }
