package com.pineapple.authserver.controller;


import com.pineapple.authserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/jwt/create")
    public String createJwt(HttpServletRequest res) throws Exception {

        return authService.makeJwt(res);
    }

    @GetMapping("/jwt/auth")
    public boolean authToken(HttpServletRequest res) throws Exception {
        String jwt = res.getParameter("jwt");

        if(jwt == null) {
            return false;
        }else {
            return authService.checkJwt(jwt);
        }
    }
}
