// package com.springcloud.feignclient1.controller;
//
// import com.springcloud.feignclient1.service.TestNodeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// @RequestMapping("/testNode")
// public class TestNodeController {
//
//     @Autowired
//     private TestNodeService testNodeService;
//
//     @GetMapping(value = "/testHello")
//     public String test(String name) {
//         return testNodeService.hello(name);
//     }
// }
