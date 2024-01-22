package com.rps.core.payout;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rps.core.burdfee.Burdfee;
import rps.core.burdfee.BurdfeeService;
import rps.core.burdfee.BurdfeeServiceImpl;
import rps.core.member.Member;
import rps.core.member.MemberService;
import rps.core.member.MemberServiceImpl;
import rps.core.member.MemberType;
import rps.core.payout.Payout;
import rps.core.payout.PayoutService;
import rps.core.payout.PayoutServiceImpl;

public class PayoutServiceTest {

    MemberService memberService = new MemberServiceImpl();
    BurdfeeService burdfeeService = new BurdfeeServiceImpl();
    PayoutService payoutService = new PayoutServiceImpl();

    @DisplayName("개인고객의 퇴직일시금 지급 테스트")
    @Test
    void fullPayout() {
        // given
        Member member = new Member(1L, "personalMemberA", MemberType.PER);
        memberService.join(member);
        Burdfee burdfee = burdfeeService.payinBurdfee(member.getId(), 1000000L);

        // when
        Payout payout = payoutService.createPayout(member.getId(), "퇴직일시금");


        //then
        Assertions.assertThat(burdfee.getPayinAmt()).isEqualTo(1000000L);

        Assertions.assertThat(payout.getMemberId()).isEqualTo(member.getId());
        Assertions.assertThat(payout.getPayoutAmt()).isEqualTo(1000000L);
        Assertions.assertThat(payout.getPaymentPolicy()).isEqualTo("퇴직일시금");

        Assertions.assertThat(member.getLimitPayinAmt()).isEqualTo(18000000L);
        Assertions.assertThat(member.getLimitTaxAmt()).isEqualTo(9000000L);
    }

}
