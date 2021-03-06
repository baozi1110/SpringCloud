package com.qp.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient//让该应用称为Eureka客户端，以获得服务发现的能力
@EnableCircuitBreaker // 开启断路器功能
@SpringBootApplication
public class RibbonConsumerApplication {

    /**
     *
     * @LoadBalanced// 开启客户端负载均衡
     */
    @Bean
    @LoadBalanced// 开启负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

}
