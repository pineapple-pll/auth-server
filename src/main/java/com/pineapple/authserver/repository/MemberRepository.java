package com.pineapple.authserver.repository;

import com.pineapple.authserver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();

    List<Member> findByName(String memberId);

    Member findByMemberId(String memberId);
}
