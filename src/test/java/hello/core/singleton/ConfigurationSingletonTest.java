package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepositiry;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepositiry memberRepository = ac.getBean("memberRepositiry", MemberRepositiry.class);

        MemberRepositiry memberRepositiry1 = memberService.getMemberRepositiry();
        MemberRepositiry memberRepositiry2 = orderService.getMemberRepositiry();

        System.out.println("memberService -> memberRepositiry1 = " + memberRepositiry1);
        System.out.println("orderService -> memberRepositiry2 = " + memberRepositiry2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepositiry()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepositiry()).isSameAs(memberRepository);

    }
}
