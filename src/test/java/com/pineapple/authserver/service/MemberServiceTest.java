package com.pineapple.authserver.service;

import com.pineapple.authserver.constant.MemberErrorCode;
import com.pineapple.authserver.domain.Member;
import com.pineapple.authserver.dto.MemberDto;
import com.pineapple.authserver.exception.PineException;
import com.pineapple.authserver.repository.MemberRepository;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    AuthService authService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 로그인성공() throws Exception {
        // given
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId("test1");
        memberDto.setPassword("1234");

        // when
        String jwt = memberService.loginMember(memberDto);
        boolean isSuccess = authService.checkJwt(jwt);

        // then
        assertTrue("로그인 실패", isSuccess);
    }

    @Test
    public void 로그인실패() throws Exception {
        // given
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId("yunjea0312");
        memberDto.setPassword("1234");

        // then
       assertThrows(PineException.class, () -> {
           // when
           memberService.loginMember(memberDto);
       });
    }

    @Test
    public void 회원가입성공() {
        // given
        Member member = new Member();
        member.setMemberId("test" + RandomString.make(5));
        member.setAddress("테스트 주소");
        member.setAge(100);
        member.setCountry("서울");
        member.setEmail("test@pine.wiro.kr");
        member.setGender("W");
        member.setName("testtest");
        member.setPassword("1234");
        member.setPhone("01011112222");
        member.setProfile("");
        member.setActive("Y");

        // when
        Long id = memberService.join(member);
        em.flush();

        // then
        assertEquals(member, memberRepository.findOne(id));
    }

    @Test
    public void 회원가입실패_중복아이디() {
        // given
        Member member = new Member();
        member.setMemberId("test1");
        member.setAddress("테스트 주소");
        member.setAge(100);
        member.setCountry("서울");
        member.setEmail("test@pine.wiro.kr");
        member.setGender("W");
        member.setName("testtest");
        member.setPassword("1234");
        member.setPhone("010-1111-2222");
        member.setProfile("");

        // then
        assertThrows(PineException.class, () -> {
            // when
            memberService.join(member);
        });
    }
}
