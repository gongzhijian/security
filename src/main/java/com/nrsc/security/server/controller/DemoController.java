package com.nrsc.security.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello spring-security";
    }

    @GetMapping("/me1")
    public Object getCurrentUser1() {
        //方式1，直接从SecurityContextHolder中拿到Authentication对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/me2")
    public Object getCurrentUser2(Authentication authentication) {
        //方式2---方式1的简写版
        return authentication;
    }

    @GetMapping("/me3")
    public Object getCurrentUser3(@AuthenticationPrincipal UserDetails user) {
        //方式3，只获取User对象
        return user;
    }
}
