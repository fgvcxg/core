package hello.core.member;

public interface MemberRepositiry {

    void save(Member member);


    Member findById(Long memberId);


}
