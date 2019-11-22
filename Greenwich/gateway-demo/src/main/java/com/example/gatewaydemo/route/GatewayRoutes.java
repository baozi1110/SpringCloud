package com.example.gatewaydemo.route;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Route实例的配置类
 *
 * @author Baozi
 */
@Configuration
public class GatewayRoutes {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/java/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("https://www.baidu.com/")
                )
                .route(r -> r
                        .path("/oauth2-client/**")
                        .filters(f->f.stripPrefix(1))
                        .uri("lb://oauth2-client")
                        .id("oauth2-client")
                )
                //oauth2权限认证服务器
                .route(r -> r
                        .path("/oauth2-server/**")
                        .filters(f->f.stripPrefix(1))
                        .uri("lb://oauth2-server")
                        .id("oauth2-server")
                )
                .build();
    }


}
