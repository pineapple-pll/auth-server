package com.pineapple.authserver.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberErrorCode {

    SIGNINFAIL(510, "아이디 또는 비밀번호가 일치하지 않습니다."),
    SIGNUPFAIL(511, "회원가입이 실패했습니다."),
    DUPLICATEMEMBER(512, "이미 존재하는 회원입니다.");

    private int code;
    private String description;
}
