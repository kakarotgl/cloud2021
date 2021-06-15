package com.kaka.auth.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/getCurrentUser")
    @ApiOperation(value = "获取用户信息")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
