package com.wkimdev.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.goods.handler.GoodsHistoryHandler;
import com.wkimdev.service.order.OrderHistoryService;
import com.wkimdev.service.order.handler.OrderHistoryHandler;

@EnableWebFlux
@Configuration
public class WebFluxRouter extends DelegatingWebFluxConfiguration {
	
//	- select show
//	- select artist 
//	- choose date ( 프론트엔드 라이브러리..?)
//	- choose seat (R, S, A)
//	- buy ticket
//	- buy item (프로그램북, 굿즈) 
//	- login
//	- logout
	
	@Autowired
	private GoodsHistoryHandler goodsHistoryHandler;
	
	@Autowired
	private OrderHistoryHandler orderHistoryHandler;
	
	@Bean
	public RouterFunction<ServerResponse> orderServiceRouter() {

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
			
		 return route(GET("/show/lists").and(accept(APPLICATION_JSON)), goodsHistoryHandler::findAll)
				.andRoute(POST("/show/lists").and(accept(APPLICATION_JSON)), goodsHistoryHandler::save)
				.andRoute(GET("/order/history").and(accept(APPLICATION_JSON)), orderHistoryHandler::findAll)
	 			.andRoute(POST("/order/history").and(accept(APPLICATION_JSON)), orderHistoryHandler::save)
		 		.andRoute(POST("/order/complete").and(accept(APPLICATION_JSON)), orderHistoryHandler::update);
	}
	
}
