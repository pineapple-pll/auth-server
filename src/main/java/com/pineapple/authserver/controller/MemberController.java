package com.pineapple.authserver.controller;

import com.pineapple.authserver.dto.MemberDto;
import com.pineapple.authserver.response.Response;
import com.pineapple.authserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth-server/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public ResponseEntity list() {
        List<MemberDto> members = memberService.findMembers();

        Response response = new Response(members.size(), members);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
