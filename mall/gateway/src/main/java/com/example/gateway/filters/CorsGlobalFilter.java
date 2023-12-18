package com.example.gateway.filters;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @Title: CorsGlobolFilter.java
 * @Author: HSL
 * @Date: 2023/12/15 10:50
 * @Description:
 */


//Gateway对于options请求有特殊机制
//@Component
public class CorsGlobalFilter {


    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "Content-Type,authorization");
        return chain.filter(exchange);
    }

    public int getOrder() {
        return 0;
    }
}
