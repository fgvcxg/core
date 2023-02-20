package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//2023-02-20 5. 싱글톤 컨테이너
// @Configuration과 바이트 코드 조작의 마법
//@Configuration 를 붙이면 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장한다
//이것을 주석처리하면 CGLIB 기술을 쓰지 않게 된다
//또 스프링 빈들도 다 등록이 되지만 예전처럼 싱글톤이 되지 않고 자바 코드 그 자체로 출력이 된다
//
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository() 호출한다
    //@Bean orderService -> new MemoryMemberRepository() 호출한다

    //AppConfig.memberService
    //AppConfig.memberRepositiry
    //

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepositiry());
    }

    @Bean
    //public static MemoryMemberRepository memberRepositiry() {return new MemoryMemberRepository();}
    public MemoryMemberRepository memberRepositiry() {
        //@Configuration과 @Bean의 조합으로 싱글톤을 보장하는 경우는 정적이지 않은 메서드일 때입니다.
        //정적 메서드에 @Bean을 사용하게 되면 싱글톤 보장을 위한 지원을 받지 못합니다.
        System.out.println("AppConfig.memberRepositiry");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepositiry(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {

        return  new RateDiscountPolicy();
    }


}
