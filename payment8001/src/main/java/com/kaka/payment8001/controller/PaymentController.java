package com.kaka.payment8001.controller;

import com.kaka.payment8001.service.AccessIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private AccessIpService accessIpService;

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

    @GetMapping("/ip")
    public String getIp(HttpServletRequest request){
        return accessIpService.getAccessIp(request);
    }
}
