package rps.core;

import rps.core.member.Member;
import rps.core.member.MemberService;
import rps.core.member.MemberServiceImpl;
import rps.core.member.MemberType;

public class RPSAPP {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "personalMemberA", MemberType.PER);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }

}
