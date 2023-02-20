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

    //2023-02-20 5. 싱글톤 컨테이너
    // @Configuration과 바이트 코드 조작의 마법
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$641ec7cb
        //이렇게 출력이 되는데 이것은 Bean을 등록을 해서 컨테이너에서 생성을 했기 때문에 위에 이렇게 붙는 것이다
        

    }
}
