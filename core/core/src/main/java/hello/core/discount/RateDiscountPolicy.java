package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPrecent = 10;

    @Override
    public int discount(Member member, int price){
        if (member.getGrade() == Grade.VIP){
            return price * discountPrecent / 100;
        } else{
//            System.out.println("안됨");
            return 0;
        }
    }
}
