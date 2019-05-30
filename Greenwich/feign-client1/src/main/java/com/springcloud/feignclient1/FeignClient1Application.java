package com.springcloud.feignclient1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.springcloud.feignclient1.service"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.springcloud.feignclient1.service", "com.springcloud.feignclient1.controller"})
public class FeignClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignClient1Application.class, args);
    }
}

