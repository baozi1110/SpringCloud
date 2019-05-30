package com.springcloud.feignclient1.service;

import com.example.eurekafeignapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign-service1")
public interface HelloServiceClient extends HelloService {
}
