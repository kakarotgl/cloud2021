package com.kaka.order8003.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable String id);
}
