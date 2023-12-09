# 스프링 핵심 원리 실습용 퇴직연금시스템
<br/>

## 비즈니스 요구사항과 설계
### 퇴직연금 가입자
- 가입자를 가입하고 조회할 수 있다.
- 가입자는 기업고객과 개인고객 두 가지 종류가 있다.
- 가입자 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
### 퇴직연금 부담금 입금 정책
- 가입자는 퇴직연금 계좌에 돈을 입금할 수 있다.
- 퇴직연금 가입자의 종류에 따라 다른 종류의 부담금이 입금된다.
### 퇴직연금 연금 및 일시금 지급 정책
- 가입자는 퇴직연금 계좌에서 돈을 인출할 수 있다.
- 돈은 일시금으로 받을 수도 있고, 달마다 연금으로 나누어 받을 수도 있다.

#### 참고
- `객체지향 핵심 원리를 적용시키기 위한 예제 프로그램이 목적`이기 때문에 자산운용이나 입금 및 지급 시 자격확인 등의 세세한 부분은 기재하지 않았다.
<br/>

## 퇴직연금 가입자 도메인 설계
### 퇴직연금 가입자 도메인 요구사항
- 가입자를 가입하고 조회할 수 있다.
- 가입자는 기업고객과 개인고객 두 가지 종류가 있다.
- 가입자 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
<br/>

#### 퇴직연금 가입자 도메인 협력 관계
![가입자 도메인](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/359ac1dd-a920-411b-96d2-4642ba76cb4a)
<br/><br/>

#### 퇴직연금 가입자 클래스 다이어그램
![가입자 클래스 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/626a7b0f-07d3-481b-bb0b-89beff40630c)
<br/><br/>

#### 퇴직연금 가입자 객체 다이어그램
![가입자 객체 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/08e8d0e5-768c-484d-a70b-c23951b6e2cd)
<br/><br/>

## 퇴직연금 가입자 도메인 개발
[퇴직연금 가입자 개발 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/tree/main/src/main/java/rps/core/member)
<br/><br/>

## 퇴직연금 가입자 도메인 실행과 테스트
[퇴직연금 가입자 테스트 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/blob/main/src/test/java/com/rps/core/member/MemberServiceTest.java)
<br/><br/>
