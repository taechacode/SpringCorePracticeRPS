package rps.core.payout;

public interface PayoutService {

    Payout createPayout(Long memberId, String paymentPolicy);

}
