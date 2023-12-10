package rps.core.burdfee;

public class Burdfee {

    private Long memberId;
    private Long payinAmt;
    private String payinResult;

    public Burdfee(Long memberId, Long payinAmt, String payinResult) {
        this.memberId = memberId;
        this.payinAmt = payinAmt;
        this.payinResult = payinResult;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPayinAmt() {
        return payinAmt;
    }

    public void setPayinAmt(Long payinAmt) {
        this.payinAmt = payinAmt;
    }

    public String getPayinResult() {
        return payinResult;
    }

    public void setPayinResult(String payinResult) {
        this.payinResult = payinResult;
    }
}
