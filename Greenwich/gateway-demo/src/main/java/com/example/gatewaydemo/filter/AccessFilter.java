package com.example.gatewaydemo.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.gatewaydemo.Constant.UaaConstant;
import com.example.gatewaydemo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Baozi
 */
@Component
public class AccessFilter implements GlobalFilter, Ordered {

    /**
     * url匹配器
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private AuthIgnored authIgnored;

    @Override
    public int getOrder() {
        return -500;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String accessToken = TokenUtil.extractToken(exchange.getRequest());

        // 是否通过验证，通过则不需要验证
        boolean isPassVerification = false;

        for (String ignored : authIgnored.getIgnored()) {
            if (pathMatcher.match(ignored, exchange.getRequest().getPath().value())) {
                // 白名单
                isPassVerification = true;
            }
        }


        if (isPassVerification) {
            return chain.filter(exchange);
        } else {
            // Map<String, Object> params = (Map<String, Object>) redisTemplate.opsForValue().get(UaaConstant.TOKEN+":" + accessToken);
            String params = redisTemplate.opsForValue().get(UaaConstant.TOKEN + ":" + accessToken);

            if (params != null) {
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                ServerHttpResponse response = exchange.getResponse();
                JSONObject message = new JSONObject();
                message.put("resp_code", 401);
                message.put("resp_msg", "未认证通过！");
                byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = response.bufferFactory().wrap(bits);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                // 指定编码，否则在浏览器中会中文乱码
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            }
        }
    }
}
