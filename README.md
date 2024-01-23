# 스프링 핵심 원리 실습용 퇴직연금시스템
<br/>

## 비즈니스 요구사항과 설계
### 퇴직연금 가입자
- 가입자를 가입하고 조회할 수 있다.
- 가입자는 기업고객과 개인고객 두 가지 종류가 있다.
- 가입자 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
### 퇴직연금 부담금 정책
- 가입자는 퇴직연금 계좌에 돈을 입금할 수 있다.
- 부담금을 납입하는 퇴직연금 가입자의 종류에 따라 다른 종류의 부담금이 입금된다. (2023.12.09 부담금 주체 추가)
- 부담금을 납입하는 퇴직연금 가입자의 종류가 개인고객일 경우 세액공제 한도는 900만원이다. 가입자의 종류 상관없이 부담금 전체 저축 한도는 1,800만원이다. (2023.12.09 저축 한도 요건 추가)
### 퇴직연금 지급 정책
- 가입자는 퇴직연금 계좌에서 돈을 인출할 수 있다.
- 돈은 현재는 전액 일시금으로 지급하고 있지만, 나중에는 연금으로만 수급해야 할 수도 있다. (2023.12.09 객체지향 설계 예시를 적용하기 위한 요건 변경. 현재는 2022.04.01부터 퇴직금의 개인형 IRP 이전 의무화)
- 일시금과 연금으로 지급받을 때의 세율이 다르다. (2023.12.09 세율 요건 추가)

#### 참고
- `객체지향 핵심 원리를 적용시키기 위한 예제 프로그램이 목적`이기 때문에 자산운용이나 입금 및 지급 시 자격확인 등의 세세한 부분은 기재하지 않았다.
<br/><br/><br/>

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
<br/><br/><br/>

## 퇴직연금 부담금 입금도메인 설계
### 퇴직연금 부담금 정책 요구사항
- 가입자는 퇴직연금 계좌에 돈을 입금할 수 있다.
- 부담금을 납입하는 퇴직연금 가입자의 종류에 따라 다른 종류의 부담금이 입금된다. (2023.12.09 부담금 주체 추가)
- 부담금을 납입하는 퇴직연금 가입자의 종류가 개인고객일 경우 세액공제 한도는 900만원이다. 가입자의 종류 상관없이 부담금 전체 저축 한도는 1,800만원이다. (2023.12.09 저축 한도 요건 추가)

#### 퇴직연금 부담금 도메인 협력, 역할, 책임
![퇴직연금 부담금 거래](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/c4bee70d-567d-4d0c-b464-539af37de72a)
<br/><br/>

**1. 입금 거래 생성 :** 클라이언트는 부담금 서비스에 입금 거래 생성을 요청한다. <br/>
**2. 회원 조회 :** 한도 정보를 통해 입금 가능 여부를 확인한다. <br/>
**3. 입금 처리 :** 2번 단계를 통해 입금이 가능한 고객이라면, 가입자 종류에 따라 부담금을 적립한다. <br/>
**4. 입금 결과 반환 :** 부담금 서비스는 한도 확인 결과를 포함한 입금 결과를 반환한다. <br/>

#### 퇴직연금 부담금 클래스 다이어그램
![부담금 클래스 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/d4436acb-16a7-4ef1-b3e7-ca212c754a19)
<br/><br/>

#### 퇴직연금 부담금 객체 다이어그램
![부담금 객체 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/ad24adba-ba2c-41b7-885d-c297706ea6a2)
<br/><br/>

## 퇴직연금 부담금 도메인 개발
[퇴직연금 부담금 개발 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/tree/main/src/main/java/rps/core/burdfee)
<br/><br/>

## 퇴직연금 부담금 도메인 실행과 테스트
[퇴직연금 부담금 테스트 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/blob/main/src/test/java/com/rps/core/burdfee/BurdfeeServiceTest.java)
<br/><br/><br/>

## 퇴직연금 지급 도메인 설계
### 퇴직연금 지급 정책 요구사항
- 가입자는 퇴직연금 계좌로부터 돈을 일시금의 방식으로 지급받을 수 있다.
- 퇴직연금을 지급하면 가입자가 받을 수 있는 부담금 한도는 올라간다.
- 퇴직연금 지급 방식은 나중에 일시금의 방식뿐만 아니라 연금의 지급 방식을 지원할 수도 있다. (미확정)

#### 퇴직연금 지급 도메인 협력, 역할, 책임
![퇴직연금 지급 거래](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/0f929718-2779-40c4-bdbd-2cc083637906)
<br/><br/>

**1. 지급 거래 생성 :** 클라이언트는 지급 서비스에 지급 거래 생성을 요청한다. <br/>
**2. 회원 조회 :** 잔고 정보를 통해 지급 가능 금액을 확인한다. <br/>
**3. 지급 처리 :** 2번 단계를 통해 지급 가능 금액을 출금하고, 부담금 한도 정보를 갱신시켜준다. <br/>
**4. 지급 결과 반환 :** 지급 서비스는 지급 금액과 지급 방식을 포함한 지급 결과를 반환한다. <br/>

#### 퇴직연금 지급 클래스 다이어그램
![지급 클래스 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/7f90db42-4bfd-4ef7-be17-f2a3500daee6)
<br/><br/>

#### 퇴직연금 지급 객체 다이어그램
![지급 객체 다이어그램](https://github.com/taechacode/SpringCorePracticeRPS/assets/63395751/7473649c-38ff-4d9b-bf56-38f5a0eeb8b2)
<br/><br/>

## 퇴직연금 지급 도메인 개발
[퇴직연금 지급 개발 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/tree/main/src/main/java/rps/core/payout)
<br/>
[퇴직연금 지급 정책 개발 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/tree/main/src/main/java/rps/core/payment)
<br/><br/>

## 퇴직연금 지급 도메인 실행과 테스트
[퇴직연금 지급 테스트 소스코드](https://github.com/taechacode/SpringCorePracticeRPS/blob/main/src/test/java/com/rps/core/payout/PayoutServiceTest.java)
<br/><br/><br/>
