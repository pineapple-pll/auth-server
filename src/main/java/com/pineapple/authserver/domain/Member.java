package com.pineapple.authserver.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="pp_member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "member_id")
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
