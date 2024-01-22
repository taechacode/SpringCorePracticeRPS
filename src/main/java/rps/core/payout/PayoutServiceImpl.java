package rps.core.payout;

import rps.core.member.Member;
import rps.core.member.MemberRepository;
import rps.core.member.MemoryMemberRepository;
import rps.core.payment.FullPaymentPolicy;
import rps.core.payment.PaymentPolicy;

public class PayoutServiceImpl implements PayoutService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final PaymentPolicy paymentPolicy = new FullPaymentPolicy();

    @Override
    public Payout createPayout(Long memberId, String paymentMethod) {

        Member member = memberRepository.findById(memberId);
        Long payoutAmt = paymentPolicy.calcPayoutAmt(member);

        return new Payout(memberId, paymentMethod, payoutAmt);
    }

}
