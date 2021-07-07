package com.hello.hellospring.repository;


import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberRepository {
    Member save(Member member);
    //optional - null 이 올 경우에 optnional 로 감싸져서 받음
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    //받아온 값들을 list로 반환
}
