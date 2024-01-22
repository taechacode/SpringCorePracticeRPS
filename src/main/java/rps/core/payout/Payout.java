package rps.core.payout;

public class Payout {

    private Long memberId;
    private String paymentPolicy;
    private Long payoutAmt;

    public Payout(Long memberId, String paymentPolicy, Long payoutAmt) {
        this.memberId = memberId;
        this.paymentPolicy = paymentPolicy;
        this.payoutAmt = payoutAmt;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getPaymentPolicy() {
        return paymentPolicy;
    }

    public void setPaymentPolicy(String paymentPolicy) {
        this.paymentPolicy = paymentPolicy;
    }

    public Long getPayoutAmt() {
        return payoutAmt;
    }

    public void setPayoutAmt(Long payoutAmt) {
        this.payoutAmt = payoutAmt;
    }

    @Override
    public String toString() {
        return "Payout{" +
                "memberId=" + memberId +
                ", paymentPolicy='" + paymentPolicy + '\'' +
                ", payoutAmt=" + payoutAmt +
                '}';
    }

}
