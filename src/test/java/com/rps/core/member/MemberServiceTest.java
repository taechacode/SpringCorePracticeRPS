package com.rps.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import rps.core.member.Member;
import rps.core.member.MemberService;
import rps.core.member.MemberServiceImpl;
import rps.core.member.MemberType;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test /* 퇴직연금 가입자를 MemberService를 통해 가입시키고, 조회가 정상적으로 이루어지는가? */
    void join() {
        // given
        Member member = new Member(1L, "personalMemberA", MemberType.PER);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
