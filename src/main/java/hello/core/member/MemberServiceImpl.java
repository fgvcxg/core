package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepositiry memberRepositiry;

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
