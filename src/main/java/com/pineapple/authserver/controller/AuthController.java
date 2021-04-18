package com.pineapple.authserver.controller;


import com.pineapple.authserver.response.Response;
import com.pineapple.authserver.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth-server/jwt")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/create")
    public ResponseEntity createJwt(HttpServletRequest res) throws Exception {

        Response response = new Response(0, authService.makeJwt(res));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity authToken(HttpServletRequest res) throws Exception {
        String jwt = res.getParameter("jwt");

        if(jwt == null) {
            return new ResponseEntity(false, HttpStatus.OK);
        }else {
            return new ResponseEntity(true, HttpStatus.OK);
        }
    }
}
