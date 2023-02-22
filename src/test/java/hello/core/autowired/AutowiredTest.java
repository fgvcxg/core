package hello.core.autowired;

import hello.core.member.Member;
import hello.core.member.MemberRepositiry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    //2023-02-22 7. 의존관계 자동 주입 -2 옵션 처리
    static class TestBean {

        @Autowired(required = false)
        //의존관계가 없으니 이 메소드 자체가 호출이 되지 않는다
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            //호츨은 되지만 null 로 들어간다
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            //들어왔을때 스프링 빈이 없으면 Optional.empty 로 넣어준다
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
