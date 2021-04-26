package com.pineapple.authserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pineapple.authserver.domain.Member;
import lombok.Data;

@Data
public class MemberDto {

    @JsonIgnore
    private Long id;
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

    public MemberDto() {}

    public MemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.age = member.getAge();
        this.gender = member.getGender();
        this.address = member.getAddress();
        this.profile = member.getProfile();
        this.active = member.getActive();
        this.country = member.getCountry();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }
}
