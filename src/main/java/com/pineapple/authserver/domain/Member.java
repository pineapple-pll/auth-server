package com.pineapple.authserver.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name="pp_member")
@RequiredArgsConstructor

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_id")
    private String memberId;
    @NotEmpty
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

    @Builder(builderClassName = "SignUpBuilder", builderMethodName = "SignUpBuilder")
    public Member(String memberId, @NotEmpty String name, Integer age,
                  String gender, String address, String profile,
                  String active, String country, String phone, String email,
                  String password) {
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
}
