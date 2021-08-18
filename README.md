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


<br><br>

#### (2) 스프링 핵심원리 기본편 https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8#curriculum
## 2021.07.12 ~
29 개념 복습
## SOLID 클린코드로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리
• SRP: 단일 책임 원칙(single responsibility principle) <br/>
• OCP: 개방-폐쇄 원칙 (Open/closed principle) <br/>
• LSP: 리스코프 치환 원칙 (Liskov substitution principle) <br/>
• ISP: 인터페이스 분리 원칙 (Interface segregation principle) <br/>
• DIP: 의존관계 역전 원칙 (Dependency inversion principle) <br/>

### 1.SRP 단일 책임 원칙 Single responsibility principle <br/>
• 한 클래스는 하나의 책임만 가져야 한다. <br/>
• 하나의 책임이라는 것은 모호하다. <br/>
• 클 수 있고, 작을 수 있다. <br/>
• 문맥과 상황에 따라 다르다. <br/>
• 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것 <br/>
• 예) UI 변경, 객체의 생성과 사용을 분리 <br/>

### 2.OCP 개방-폐쇄 원칙 Open/closed principle <br/>
• 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다 <br/>
• 이런 거짓말 같은 말이? 확장을 하려면, 당연히 기존 코드를 변경? <br/>
• 다형성을 활용해보자 <br/>
• 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현 <br/>
• 지금까지 배운 역할과 구현의 분리를 생각해보자 <br/>

#### 문제점 <br/>
• MemberService 클라이언트가 구현 클래스를 직접 선택 <br/>
• MemberRepository m = new MemoryMemberRepository(); //기존 코드 <br/>
• MemberRepository m = new JdbcMemberRepository(); //변경 코드 <br/>
• 구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다. <br/>
• 분명 다형성을 사용했지만 OCP 원칙을 지킬 수 없다. <br/>
• 이 문제를 어떻게 해결해야 하나? <br/>
• 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다 <br/>

### 3.LSP 리스코프 치환 원칙 Liskov substitution principle <br/>
• 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀수 있어야 한다 <br/>
• 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다. <br/>
• 단순히 컴파일에 성공하는 것을 넘어서는 이야기 <br/>
• 예) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함

### 4.ISP 인터페이스 분리 원칙 Interface segregation principle <br/>
• 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다 <br/>
• 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리 <br/>
• 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리 <br/>
• 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음 <br/>
• 인터페이스가 명확해지고, 대체 가능성이 높아진다. <br/>

### 5.DIP 의존관계 역전 원칙 Dependency inversion principle <br/>
• 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중 하나다. <br/>
• 쉽게 이야기해서 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻 <br/>
• 앞에서 이야기한 역할(Role)에 의존하게 해야 한다는 것과 같다. 객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다! 구현체에 의존하게 되면 변경이 아주 어려워진다. <br/>
• 그런데 OCP에서 설명한 MemberService는 인터페이스에 의존하지만, 구현 클래스도 동시에 의존한다. <br/>
• MemberService 클라이언트가 구현 클래스를 직접 선택 <br/>
• MemberRepository m = new MemoryMemberRepository(); <br/>
• DIP 위반 <br/>

### 정리
• 객체 지향의 핵심은 다형성 <br/>
• 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다. <br/>
• 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다. <br/>
• 다형성 만으로는 OCP, DIP를 지킬 수 없다. <br/>
• 뭔가 더 필요하다. <br/>

### 실습
- interfafce는 객체의 사용 방법을 정의한 타입이다. 객체의 교환성을 높여주기 때문에 다형성을 구현하는데에 매우 중요한 역할을 한다.개발 코드를 수정하지 않고도 사용하는 객체를 변경할 수 있다는 것!


### 프레임워크 vs 라이브러리
프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다. (JUnit)
반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.


### 컴포넌트 스캔
- Appconfig에서 등록한 @Bean들은 일일히 추가해야함.
- 컴포넌트 스캔방식으로 자동으로 의존관계 주입이 되도록 가능 / @Bean이 들어가야 하는 곳에 (@Autowried, @Component) 추가
- 탐색할 패키지 위치 지정
```
@ComponentScan(
basePackages = "hello.core",
}
```

- 다양한 의존관계 주입 방법
  - 생성자 주입
  - 수정자 주입(setter 주입)
  - 필드 주입
  - 일반 메서드 주입

- 필터타입

### lombok 적용
롬복 라이브러리가 제공하는 @RequiredArgsConstructor 기능을 사용하면 final이 붙은 필드를 모아서
생성자를 자동으로 만들어준다. (다음 코드에는 보이지 않지만 실제 호출 가능하다.)
최종 결과는 다음과 같다! 정말 간결하지 않은가!
``` java
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
private final MemberRepository memberRepository;
private final DiscountPolicy discountPolicy;
}
```
