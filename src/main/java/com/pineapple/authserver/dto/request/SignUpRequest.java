package com.pineapple.authserver.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {
    private String memberId;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String profile;
    private String active;
    private String country;
    private String phone;
    private String email;
    private String password;


}
