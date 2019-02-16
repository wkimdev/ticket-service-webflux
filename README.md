## ticket service webflux
- 티켓 예매 서비스 with webflux 
- 사용자에게 빠른 예매서비스를 제공하기 위해 webflux를 사용합니다. 

## API 
  
```
//		 1. select 공연 내역
//			- 공연 카테고리 플래그 코드  
//			- 전체 공연 리스트	
//			- 공연 디테일 내역  
		
//		 2. 공연 내역 추가 - admin 
//			- 공연 내용 insert 
			
//		 3. order 내역 insert, select
//			- 선택한 공연 주문하기
//			- 선택한 공연 내역 확인(공연 내용과 결재내역)
			
		
//		 4. buy 결재하기 
//			- 결재 내역 플래그 걸기 : order_history table에 flag 컬럼에 업데이트 
```
  
  
# show table 구성
- show_name, 장르(뮤지컬, 콘서트, 연극), 러닝타임, 관람가능연령, 기간(2019.03.09 ~ 2019.04.21), 장소, 부제, 출연 
- 

# tech stack
- spring boot, rxjava2, webflux  


# 
jpa 장점 : db간 마이그레이션 스키마 변경 빼곤 큰 코드 변경 없이 사용할 수 있음.

# aa
- webflux 학습 내용 link
- spring data 학습 내용

  