package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//2023-02-21 6 - 1 컴포넌트 스캔과 의존관계 주입 수정
public class MemberServiceImpl implements MemberService{

    private final MemberRepositiry memberRepositiry;

    @Autowired
    //2023-02-21 6 - 1 컴포넌트 스캔과 의존관계 주입 수정
    public MemberServiceImpl(MemberRepositiry memberRepositiry) {
        this.memberRepositiry = memberRepositiry;
    }

    @Override
    public void join(Member member) {
        memberRepositiry.save(member);
    }

    @Override
    public Member findByMember(Long memberId) {
        return memberRepositiry.findById(memberId);
    }
    
    //테스트 용도
    public MemberRepositiry getMemberRepositiry() {
        return memberRepositiry;
    }
    
}
