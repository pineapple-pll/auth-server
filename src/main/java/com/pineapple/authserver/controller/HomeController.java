package com.pineapple.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-server")
public class HomeController {

    @GetMapping
    public String home() {
        return "pineapple 인증서버";
    }
}
