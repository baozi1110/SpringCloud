package com.qp.cloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaServer

public class CloudApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudApplication.class).web(true).run(args);
    }

}
