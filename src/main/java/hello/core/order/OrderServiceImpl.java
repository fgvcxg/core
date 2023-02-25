package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepositiry;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{



    private final MemberRepositiry memberRepositiry;
    private final DiscountPolicy discountPolicy;


    //2023-02-22 7. 의존관계 자동 주입 - 다양한 의존관계 주입방법
    //스프링 컨테이너(수정자)는 빈을 다 등록하는 것과 연관관계 걸린애들을 주입하는 것 이렇게 2가지 라이프 사이클로 나뉘어 있다
    //생성자도 주입이 되지만 조금 특이하다
    //생성자 주입은 빈을 등록하면서 의존관계가 같이 주입이 된다. 일반적인 자바코드이기 때문에 어쩔수 없이 스프링 컨테이너에서 등록되어 생성을 하기 때문이다
    //요즘엔 생성자 주입을 많이 쓰지만 수정자 주입은 아주 가끔은 쓰인다

//    @Autowired
//    public void setMemberRepositiry(MemberRepositiry memberRepositiry) {
//        System.out.println("memberRepositiry = " + memberRepositiry);
//        this.memberRepositiry = memberRepositiry;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    //필드 주입
    //@Autowired private  MemberRepositiry memberRepositiry;
    //@Autowired private  DiscountPolicy discountPolicy;
    //이렇게 추가를 해주는 방식이다 의존관계를 필드에서 주기때문이다
    //하지만 요즘은 필드 주입은 권장하지 않는다
    // 외부에서 변경이 불가능해서 테스트하기가 쉽지 않다
    //코드가 간결해서 많은 개발자들을 유혹하지만 외부에서 변경이 불가능해서 테스트하기가 쉽지 않다는 단점이 있다
    //DI 프레임 워크가 없으면 아무것도 못한다
    //테스트 할때는 써도 된다.
    
    
    //일반 메서드 주입
    //진짜 아무 메서드에 @Autowired 주입하는 것이다
    //수정자 주입이랑 비슷하다
    //한번에 여러 필드를 주입 받을 수 있지만 생성자 주입이랑 수정자 주입안에서 해결하기 때문에 일반적으로 잘 사용할 수 없다
    //의존관계 자동 주입은 스프링 컨테이너가관리하는 스프링 빈이어야 동작한다.
    //스프링 빈에 등록된 개체여만 가능하다



    //2023-02-22 7. 의존관계 자동 주입 -3 생성자 주입을 선택하라
    @Autowired
    public OrderServiceImpl(MemberRepositiry memberRepositiry, DiscountPolicy discountPolicy) {
        this.memberRepositiry = memberRepositiry;
        this.discountPolicy = discountPolicy;
    }
    //위에 생성자 주입을 할때 final 을 적으면 컴파일에서 초기화 할때 들어와야 하는 값이 들어오지 않았다고 하며 오류가 난다
    //그렇기에 생성자 주입을 하면서 final 을 쓰는 것이 좋다
    //생성자 주입 방식을 선택하는 이유는 여러가지가 있지만, 프레임 워크에 의존하지 않고, 순수한 자바 언어의 특징을 잘 살리는 방법
    //기본으로 생성자 주입을 사용하고, 필수 값이 아닌 경우에는 수정자 주입 방식으로 옵션으로 부여하면 된다. 생성자 주입과 수정자 주입을 동시에 사용할 수 있다
    //항상 생성자 주입을 선택하고 가끔 옵션이 필요하면 수정자 주입을 선택하라. 필드 주입은 사용하지 않는 게 좋다

//    @Autowired
//    public void setMemberRepositiry(MemberRepositiry memberRepositiry) {
//        this.memberRepositiry = memberRepositiry;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

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
