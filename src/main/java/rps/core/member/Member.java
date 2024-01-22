package rps.core.member;

public class Member {

    private Long id;
    private String name;
    private MemberType memberType;
    private Long burdfeePayinAmt;
    private Long limitPayinAmt;
    private Long limitTaxAmt;
    private int pensionCount;

    public Member(Long id, String name, MemberType memberType) {
        this.id = id;
        this.name = name;
        this.memberType = memberType;
        this.burdfeePayinAmt = 0L;
        this.limitPayinAmt = 18000000L;
        this.limitTaxAmt = 0L;
        if(memberType == MemberType.PER) {
            limitTaxAmt = 9000000L;
        }
        this.pensionCount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public Long getBurdfeePayinAmt() {
        return burdfeePayinAmt;
    }

    public void setBurdfeePayinAmt(Long burdfeePayinAmt) {
        this.burdfeePayinAmt = burdfeePayinAmt;
    }

    public Long getLimitPayinAmt() {
        return limitPayinAmt;
    }

    public void setLimitPayinAmt(Long limitPayinAmt) {
        this.limitPayinAmt = limitPayinAmt;
    }

    public Long getLimitTaxAmt() {
        return limitTaxAmt;
    }

    public void setLimitTaxAmt(Long limitTaxAmt) {
        this.limitTaxAmt = limitTaxAmt;
    }

    public int getPensionCount() {
        return pensionCount;
    }

    public void setPensionCount(int pensionCount) {
        this.pensionCount = pensionCount;
    }
}
