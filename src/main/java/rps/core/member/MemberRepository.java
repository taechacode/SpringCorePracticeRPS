package rps.core.member;

public interface MemberRepository {
    
    // 가입자 저장
    void save(Member member);

    // ID를 기준으로 가입자 정보 색인
    Member findById(Long memberId);

}
