package com.kaka.gateway.conf;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MayiktGatewayFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从我们的nginx 重写请求获取的参数
        String sourceIp = exchange.getRequest().getHeaders().getFirst("X-Real-IP");
        System.out.println(sourceIp);
        if (StringUtils.isEmpty(sourceIp)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "500");
            jsonObject.put("msg", "sourceIp is null");
            DataBuffer buffer = response.bufferFactory().wrap(jsonObject.toJSONString().getBytes());
            return response.writeWith(Mono.just(buffer));
        }
        // 放行执行转发到我们的服务
        return chain.filter(exchange);

    }
}
