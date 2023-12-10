package rps.core.burdfee;

import rps.core.member.*;

public class BurdfeeServiceImpl implements BurdfeeService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Burdfee payinBurdfee(Long memberId, Long payinAmt) {

        Member member = memberRepository.findById(memberId);
        long ablePayinAmt = member.getLimitPayinAmt();
        if(ablePayinAmt - payinAmt < 0L) {
            return new Burdfee(memberId, payinAmt, "부담금 한도 초과");
        }

        member.setBurdfeePayinAmt(member.getBurdfeePayinAmt() + payinAmt); // 부담금 적립 처리
        member.setLimitPayinAmt(ablePayinAmt - payinAmt); // 부담금 입금 한도 차감 처리
        
        // 부담금 입금 주체가 개인 고객일 경우 세액공제한도 차감 처리
        if(member.getMemberType() == MemberType.PER) {
            long ableTaxAmt = member.getLimitTaxAmt();
            if(ableTaxAmt - payinAmt >= 0L) {
                member.setLimitTaxAmt(ableTaxAmt - payinAmt);
            } else {
                member.setLimitTaxAmt(0L);
            }
        }

        return new Burdfee(memberId, payinAmt, "부담금 정상 입금");
    }

}
