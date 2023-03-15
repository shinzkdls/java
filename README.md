#   Banking Application Project

이번 프로젝트는 Oracle DB를 활용해, 고객,계좌,개별 이체 건에 대한 CRUD서비스와  register(회원가입),login(로그인),makeAcocunt(계좌개설),transaction(계좌이체) 서비스를 포함하였습니다.
<br><br>

### 🚀 UML 구조

<img width="1674" alt="스크린샷 2022-03-25 오후 4 55 35" src="https://github.com/abdevelo/java/blob/assignment/final_ws0315/UML.jpg" >


### 🚀 개발 인원 및 기간

- 개발 인원 : 4명
- 개발 기간 : 2023/3/15 13:00 ~ 2023/3/15 18:00 (5시간)
<br><br>

# 💡 초기기획 & ERD

## flow

BankUser가입 > BankUser로그인 > 계좌개설 > 계좌조회 > 계좌이체 > 거래내역조회 > 거래종

## 구현 목표

- User,Account,Transaction 개체의 유기적인 관계를 구현
- Transaction기능의 수행에 따른 결과가 DAO에 반영되어 DB에 저장

<br><br>

# 📝 적용 기술 및 구현 기능

- ## 기술 스택
  - ### Back-end
    - 자바 11
    - 오라클 DB
    - GIT

- ## 구현기능
  - 구현기능
    - register : BankUser를 등록합니다.
    <img width="800" alt="스크린샷" src="https://github.com/shinzkdls/java/blob/assignment/final_ws0315/src/image/ws0315_register.png" >
    <br>
    - login : BankUser의 정보로 로그인합니다.
    <img width="800" alt="스크린샷" src="https://github.com/shinzkdls/java/blob/assignment/final_ws0315/src/image/ws0315_login.png" >
    <br>
    - makeAccount : 계좌를 생성합니다.
    - getAllAccount : 보유한 모든 계좌를 조회합니다.
    <img width="800" alt="스크린샷" src="https://github.com/shinzkdls/java/blob/assignment/final_ws0315/src/image/ws0315_makeAccount.png" >
    <br>
    - getAllTransaction : 입력한 계좌의 모든 거래내역을 조회합니다.
    - transaction : 계좌이체를 실행합니다.
    <img width="800" alt="스크린샷" src="https://github.com/shinzkdls/java/blob/assignment/final_ws0315/src/image/ws0315_transaction.png" >


<br>


# Reference

- 이 프로젝트는 Banking Application 구현을 위하여 제작되었습니다. 
- 실수수준의 프로젝트이지만 학습용으로 만들었기 떄문에 이 코드를 활용하여 이득을 취하거나 무단 배포할 경우 법적으로 문제될 수 있습니다.
- 이 프로젝트에서 사용하고 있는 로고와 배너는 해당 프로젝트 팀 소유이므로 해당 프로젝트 외부인이 사용할 수 없습니다.

![Footer](https://capsule-render.vercel.app/api?type=waving&color=ff385c&height=100&section=footer)
