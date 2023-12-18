package com.example.gateway.filters;

import com.auth0.jwt.JWT;
import com.example.gateway.jwttools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * @Title: AuthGlobalFilter.java
 * @Author: HSL
 * @Date: 2023/12/14 21:15
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取request
        ServerHttpRequest request = exchange.getRequest();

        //2.判断是否需要登陆拦截
        URI uri = request.getURI();
        String path = uri.getPath();
        System.out.println("Request Path:"+path);
        if("/user/login".equals(path) || "/user/register".equals(path)){
            return chain.filter(exchange);
        }

        //3.获取jwt token
        String token = null;
        List<String> headers = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
        if(headers!=null && !headers.isEmpty())
        {
            token = headers.get(0);
            System.out.println("This Requester Authorization Token:"+token);
        }else //若不存在token
        {
            //响应401 表示未授权
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //4.校验并且解析token
        Long userId = 0L;
        try{
            userId = Long.valueOf(JwtUtil.decodeToken(token).getSubject());
        }catch(Exception e)
        {
            //响应401 未授权
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //TODO 5.传递用户信息
        String userInfo = String.valueOf(userId);
        //重构请求头
        ServerWebExchange swe = exchange.mutate()
                .request(builder -> builder.header("user-info", userInfo))
                .build();

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
