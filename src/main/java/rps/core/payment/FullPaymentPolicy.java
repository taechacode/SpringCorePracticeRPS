package rps.core.payout;

import rps.core.member.Member;
import rps.core.member.MemberType;

public class FullPayoutPolicy implements PayoutPolicy {

    @Override
    public long payout(Member member) {

        long payoutAmt = member.getBurdfeePayinAmt();

        member.setBurdfeePayinAmt(0L);
        member.setLimitPayinAmt(Math.min(member.getLimitPayinAmt() + payoutAmt, 18000000L));
        member.setPensionCount(0);
        if(member.getMemberType() == MemberType.PER) {
            member.setLimitTaxAmt(Math.min(member.getLimitTaxAmt() + payoutAmt, 9000000L));
        }

        return payoutAmt;
    }

}
