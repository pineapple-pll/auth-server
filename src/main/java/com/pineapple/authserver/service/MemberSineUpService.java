package com.pineapple.authserver.service;

import com.pineapple.authserver.constant.MemberErrorCode;
import com.pineapple.authserver.domain.Member;
import com.pineapple.authserver.dto.MemberDto;
import com.pineapple.authserver.dto.request.SignUpRequest;
import com.pineapple.authserver.exception.PineException;
import com.pineapple.authserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberSineUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthService authService;

    /**
     * 회원 가입
     * @param signUpRequest
     */
    @Transactional
    public Long doSignUp(SignUpRequest signUpRequest) {
        // 중복 회원 검증
        validateDuplicateMember(signUpRequest);

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        Member member = signUpRequest.toEntity(encodedPassword);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(SignUpRequest signUpRequest) {
        List<Member> findMembers = memberRepository.findByName(signUpRequest.getMemberId());
        if (!findMembers.isEmpty()) {
            throw new PineException(MemberErrorCode.DUPLICATEMEMBER);
        }
    }

}


