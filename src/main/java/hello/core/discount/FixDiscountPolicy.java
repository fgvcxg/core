package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int disconutFixAmount = 1000; //1000원 할인
    @Override
    public int disconut(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return disconutFixAmount;
        }else{

            return 0;
        }

    }
}
