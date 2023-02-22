package hello.core;

import hello.core.member.MemberRepositiry;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    //2023-02-22 6. 컴포넌트 스캔 - 필터, 중복 등록과 충돌
//    @Bean(name = "memoryMemberRepository")
//    MemberRepositiry memberRepositiry() {
//        return new MemoryMemberRepository();
//    }
    //스프링 부트 테스트이기 때문에 충돌이 나서 주석처리를 한 것이다

}
