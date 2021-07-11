package com.hello.hellospring.repository;


import com.hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    // 스프링 부트가 jpa 라이브러리가 빌드되어있으면 자동으로 EmtityManager를 생성해줌.
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpql 쿼리 언어
        // 테이블 대상으로 쿼리를 날리지않고 객체를 대상으로 쿼리를 날림.
        // 그러면 쿼리로 이게 sql로 변형이 된다!
        // member를 대상으로 쿼리를 날리는 것이다.
        // 객체 자체를 select 한다.
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}