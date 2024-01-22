package rps.core.payment;

import rps.core.member.Member;

public interface PaymentPolicy {

    /*
     * @return 지급 금액
     */
    long calcPayoutAmt(Member member);
}
