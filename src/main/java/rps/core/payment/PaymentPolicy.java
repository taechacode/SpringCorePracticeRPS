package rps.core.payout;

import rps.core.member.Member;

public interface PayoutPolicy {

    /*
     * @return 지급 금액
     */
    long payout(Member member);
}
