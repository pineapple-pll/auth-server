package com.pineapple.authserver.controller;

import com.pineapple.authserver.domain.Member;
import com.pineapple.authserver.dto.MemberDto;
import com.pineapple.authserver.response.Response;
import com.pineapple.authserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 회원 가입
     */
    @PostMapping
    public ResponseEntity saveMember(@RequestBody MemberDto memberDto) {

        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        member.setActive(memberDto.getActive());
        member.setAddress(memberDto.getAddress());
        member.setAge(memberDto.getAge());
        member.setCountry(memberDto.getCountry());
        member.setEmail(memberDto.getEmail());
        member.setGender(memberDto.getGender());
        member.setName(memberDto.getName());

        member.setPassword(memberDto.getPassword());
        member.setPhone(memberDto.getPhone());
        member.setProfile(memberDto.getProfile());

        Long id = memberService.join(member);
        return new ResponseEntity(memberDto.getName(), HttpStatus.OK);
    }
}
