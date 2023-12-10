package com.rps.core.burdfee;

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

public class BurdfeeServiceTest {

    MemberService memberService = new MemberServiceImpl();
    BurdfeeService burdfeeService = new BurdfeeServiceImpl();

    @DisplayName("기업부담금 한도 내 정상 입금 처리 테스트")
    @Test
    void payinOrderENT() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", MemberType.ENT);
        memberService.join(member);

        Burdfee burdfee = burdfeeService.payinBurdfee(memberId, 1000000L);

        Assertions.assertThat(burdfee.getPayinResult()).isEqualTo("부담금 정상 입금");
        Assertions.assertThat(burdfee.getPayinAmt()).isEqualTo(1000000L);
        Assertions.assertThat(burdfee.getPayinAmt()).isEqualTo(member.getBurdfeePayinAmt());
    }

    @DisplayName("기업부담금 한도 초과 입금 처리 테스트")
    @Test
    void payinOrderOutOfLimitENT() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", MemberType.ENT);
        memberService.join(member);

        Burdfee burdfee = burdfeeService.payinBurdfee(memberId, 20000000L);

        Assertions.assertThat(burdfee.getPayinResult()).isEqualTo("부담금 한도 초과");
    }

}
