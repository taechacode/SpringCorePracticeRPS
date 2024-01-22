package rps.core.payout;

import rps.core.member.Member;
import rps.core.member.MemberType;

public class PensionPayoutPolicy implements PayoutPolicy {

    @Override
    public long payout(Member member) {

        if(member.getPensionCount() == 0) {
            member.setPensionCount(12);
        }

        long payoutAmt = member.getPensionCount() == 1 ? member.getBurdfeePayinAmt() : member.getBurdfeePayinAmt() / member.getPensionCount();

        member.setBurdfeePayinAmt(member.getBurdfeePayinAmt() - payoutAmt);
        member.setLimitPayinAmt(Math.min(member.getLimitPayinAmt() + payoutAmt, 18000000L));
        member.setPensionCount(member.getPensionCount() - 1);
        if(member.getMemberType() == MemberType.PER) {
            member.setLimitTaxAmt(Math.min(member.getLimitTaxAmt() + payoutAmt, 9000000L));
        }

        return payoutAmt;
    }

}
