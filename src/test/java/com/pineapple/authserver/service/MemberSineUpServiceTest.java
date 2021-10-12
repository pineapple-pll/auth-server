package com.pineapple.authserver.service;

import com.pineapple.authserver.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberSineUpServiceTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doSignUp() {
        sequence++;
        //given

        Member member = new Member();
        member.setMemberId("test" + sequence);
        member.setName("테스트");
        member.setPassword(passwordEncoder.encode("passwd"));
        System.out.println(member.toString());
        //when
        //then

    }
}