package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//2023-02-22 7. 의존관계 자동 주입 -3 생성자 주입을 선택하라
class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepositiry = new MemoryMemberRepository();
        memberRepositiry.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepositiry, new FixDiscountPolicy());
        //이렇게 생성자로 만들어야 빠르게 찾아서 만들수 있다, 그래서 생성자 주입을 쓰는 것이다
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDisconutPrice()).isEqualTo(1000);
    }

}