package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest

// 이 애노테이션을 테스트케이스에 달면 테스트를 실행할 때 트랜잭션을 실행하고,
// db에 데이터를 insert를 하고 test를 종료할 때 rollback()을 해준다.
// 그렇기 때문에 db에 데이터가 반영되지않는다!
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입 () {
        //given
        Member member = new Member ();
        member.setName ("spring");

        //when
        Long saveId = memberService.join (member);

        //then
        Member findMember = memberService.findOne (saveId).get ();
        assertThat (member.getName ()).isEqualTo (findMember.getName ());
    }

    @Test
    public void 중복_회원_예외 () {
        //given
        Member member1 = new Member ();
        member1.setName ("spring");

        Member member2 = new Member ();
        member2.setName ("spring");

        //when
        memberService.join (member1);
        IllegalStateException e = assertThrows (IllegalStateException.class, () -> memberService.join (member2));

        assertThat (e.getMessage ()).isEqualTo ("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then
    }
}