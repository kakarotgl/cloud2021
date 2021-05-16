package com.kaka.gateway;

import com.kaka.gateway.conf.MayiktGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 编程式定义Route
     */
    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        MayiktGatewayFilter exampleGatewayFilter = new MayiktGatewayFilter();
        StripPrefixGatewayFilterFactory stripPrefix = new StripPrefixGatewayFilterFactory();
        StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
        config.setParts(2);
        return builder.routes()
                .route("aumomo-sys", r -> r.path("/api/sys/**")
                        .filters(f -> f.filters(exampleGatewayFilter, stripPrefix.apply(config)))
                        .uri("lb://aumomo-service-sys"))
                .route("aumomo-auth", r -> r.path("/api/auth/**")
                        .filters(f -> f.filters(exampleGatewayFilter, stripPrefix.apply(config)))
                        .uri("lb://aumomo-service-oauth"))
                .route("aumomo-amazon-sellingpartner", r -> r.path("/api/amazon/**")
                        .filters(f -> f.filters(exampleGatewayFilter, stripPrefix.apply(config)))
                        .uri("lb://aumomo-service-amazon-sellingpartner"))
                .route("aumomo-service-erp", r -> r.path("/api/erp/**")
                        .filters(f -> f.filters(exampleGatewayFilter, stripPrefix.apply(config)))
                        .uri("lb://aumomo-service-erp"))
                .build();
    }*/


    @Bean
    public GlobalFilter durationStatisticsFilter() {
        return new MayiktGatewayFilter();
    }

}
