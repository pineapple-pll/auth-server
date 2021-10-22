package com.pineapple.authserver.dto.request;

import com.pineapple.authserver.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {
    private String memberId;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String profile;
    private String active;
    private String country;
    private String phone;
    private String email;
    private String password;

    public SignUpRequest(String memberId, String name, Integer age, String gender, String address, String profile, String active, String country, String phone, String email, String password) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.profile = profile;
        this.active = active;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(String encryptedPassword) {
        return Member.SignUpBuilder()
                .memberId(memberId)
                .name(name)
                .age(age)
                .address(address)
                .profile(profile)
                .country(country)
                .phone(phone)
                .email(email)
                .active(active)
                .password(encryptedPassword)
                .build();
    }
}
