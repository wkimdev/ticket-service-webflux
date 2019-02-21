# ticket service with webflux
- 추후 회사 프로젝트를 위해, 서버단의 리액티브 자바 서비스를 제공해보자 만든 간단한 프로토타입 프로젝트.
- 티켓 예매 서비스 with webflux 

# tech stack

```
- webflux  
- java8
- mongodb-reactive
- junit 5
- lombok 
- Reactor
- Rxjava2 
```
- Reactor는 RxJava2를 내부적으로 가지고 있는 녀석 @see => https://projectreactor.io/
- jdbc 설정일 경우 POM에 Rxjava2를 depengency에 설정하는 부분이 있지만 몽고디비는 그런 부분이 없는 차이가 있다(mongodb-reactive).  
  

   
  
# 서칭/학습한 내역(개인blog 정리)  
- [RxJava2 개략적 소개](https://wkimdev.github.io/rxjava2/2019/01/28/rxjava2/)
- [WebFlux(Spring WebFlux)란?](https://wkimdev.github.io/rxjava2/2019/01/28/webflux/)
- [Reactor와 Mono, Flux이해하기](https://wkimdev.github.io/rxjava2/2019/01/28/reactor/)  
  

## spring data 
- jpa는 spring data의 하위 프로젝트   
- jpa 장점 : db간 마이그레이션 스키마 변경 빼곤 큰 코드 변경 없이 사용할 수 있음.  
  



  
