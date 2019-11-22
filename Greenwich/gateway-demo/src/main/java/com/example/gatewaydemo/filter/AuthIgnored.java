package com.example.gatewaydemo.filter;

/**
 * @author Baozi
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// @ConfigurationProperties(prefix = "permit")
@ConfigurationProperties(prefix = "auth")
@Component
public class AuthIgnored{

    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {
            //aoth2权限认证
            "/**/oauth2-server/**",
            //断点监控
            "/**/actuator/**" , "/**/actuator/**/**" ,
            //swagger
            "/**/v2/api-docs/**", "/**/swagger-ui.html", "/**/swagger-resources/**", "/**/webjars/**",
            //熔断监控
            "/**/turbine.stream","/**/turbine.stream**/**", "/**/hystrix", "/**/hystrix.stream", "/**/hystrix/**", "/**/hystrix/**/**",	"/**/proxy.stream/**" ,
            "/**/druid/**", "/**/favicon.ico", "/**/prometheus"
    };

    /**
     * 需要放开权限的url
     */
    private String[] ignored;

    /**
     * 需要放开权限的url
     *
     * urls 自定义的url
     * @return 自定义的url和监控中心需要访问的url集合
     */
    public String[] getIgnored() {
        if (ignored == null || ignored.length == 0) {
            return ENDPOINTS;
        }

        List<String> list = new ArrayList<>();
        for (String url : ENDPOINTS) {
            list.add(url);
        }
        for (String url : ignored) {
            list.add(url);
        }

        return list.toArray(new String[list.size()]);
    }

    public void setIgnored(String[] ignored) {
        this.ignored = ignored;
    }

}
