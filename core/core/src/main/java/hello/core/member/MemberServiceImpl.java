package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 회원 서비스 구현체
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    //생성자에 의존관계주입
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
