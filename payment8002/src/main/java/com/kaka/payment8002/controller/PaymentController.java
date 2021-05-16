package com.kaka.payment8002.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverport;
    @GetMapping("/nacos/{id}")
    public String payment(@PathVariable String id){
        return "payment:"+serverport+"-id:"+id;
    }

    @GetMapping("/get/{id}")
    public String getServerport(@PathVariable String id){
        return "payment:"+serverport+"get:"+id;
    }

    @GetMapping("/lb")
    public String lb(){
        return "payment:"+serverport+"lb";
    }
}
