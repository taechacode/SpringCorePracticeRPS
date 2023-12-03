package rps.core.member;

public interface MemberService {
    
    // 퇴직연금 고객 신규가입
    void join(Member member);
    
    // ID를 기준으로 퇴직연금 가입자 색인
    Member findMember(Long memberId);

}
