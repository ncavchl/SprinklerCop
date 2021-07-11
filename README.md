# SprinklerCop
인프런 스프링 완전 정복 로드맵
- 스프링입문
- 스프링 핵심 원리
- 스프링 웹 mvc
- 스프링 db 데이터 접근 기술
- 실전! 스프링 부트

#### (1) Spring Study (입문-기본-핵심기술) - https://www.inflearn.com/roadmaps/373
## 2021.06.16 ~ 2021.07.12

#2021.06.30
- maven, gradle
- thymleaf
- 의존관계에 있는 라이브러리들을 자동으로 끌어옴
- spring boot start web : 톰캣웹서버, 스프링 웹 mvc 
- 스프링부트, 스프링코어, 로깅
- index.html 자동으로 찾음
- 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면 찾아서 처리함
  - 스프링 부트 템플릿 엔진 기본 viewName 매핑
  - resources:templates/ + (viewname) + .html

#빌드하기 
- gradle build
- cd build/libs
- 안에 파일 java -jar 파일명 으로 빌드


## 웹개발 방식
- 정적 컨텐츠
- MVC와 템플릿 엔진
- API

### 정적 컨텐츠 제공
- 그냥 html 파일 추가후 url 뒤에 /htmltes.html 치면 출력됨

### MVC와 템플릿 엔진
- model view controller
- 

### API
- api 방식으로 데이터를 뿌린다.
- ResponseBody : hthtp 응답 바디부에 직접 넣겠다.
- 객체(json)으로 반환하는 방식


## 테스트 케이스
### junit 을 활용

### spring bean을 등록하는 2가지 방법
- 컴포넌트 스캔과 자동 의존관계 설정
- 자바 코드로 직접 스프링 빈 등록하기 

- DI에는 필드주입, setter 주입, 생성자 주입 3가지 방법이 있다. 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.
- 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다. 
- 그리고 정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.




### DB 접근 기술
## H2 데이터 베이스
- 개발이나 테스트 용도로 가볍고 편리한 DB, 웹화면 제공
- https://www.h2database.com/

## 순수 jdbc

## 스프링 jdbctemplage

## jpa

## 스프링 데이터 jpa


## AOP
- 모든 메소드의 호출 시간을 측정하고 싶을때
- Aspect Oriented Programming
- 공통관심사항 핵심관심사항 분리 / 원하는 곳에 공통관심사항 적용


#### (2) 스프링 핵심원리 기본편 https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8#curriculum
## 2021.07.12 ~
