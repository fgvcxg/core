package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepositiry;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{



    private final MemberRepositiry memberRepositiry;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepositiry memberRepositiry, DiscountPolicy discountPolicy) {
        this.memberRepositiry = memberRepositiry;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepositiry.findById(memberId);
        int discountPrice = discountPolicy.disconut(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepositiry getMemberRepositiry() {
        return memberRepositiry;
    }
}
