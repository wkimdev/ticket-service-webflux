package com.wkimdev.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;



import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
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
			
		 return route(GET("/show/lists").and(accept(APPLICATION_JSON)), goodsHistoryHandler::findAll)
				.andRoute(GET("/show/lists/{idx}").and(accept(APPLICATION_JSON)), goodsHistoryHandler::findByIdx)
				.andRoute(GET("/show/category/{category}").and(accept(APPLICATION_JSON)), goodsHistoryHandler::findByCategory)
				.andRoute(GET("/show/artist/{artist}").and(accept(APPLICATION_JSON)), goodsHistoryHandler::findByArtist)
				.andRoute(GET("/order/history").and(accept(APPLICATION_JSON)), orderHistoryHandler::findAll)
				.andRoute(GET("/order/history/{idx}").and(accept(APPLICATION_JSON)), orderHistoryHandler::findByIdx)
				
				.andRoute(POST("/show/lists").and(accept(APPLICATION_JSON)), goodsHistoryHandler::save)
	 			.andRoute(POST("/order/history").and(accept(APPLICATION_JSON)), orderHistoryHandler::save)
		 		.andRoute(PUT("/order/complete").and(accept(APPLICATION_JSON)), orderHistoryHandler::update)
		 		.andRoute(DELETE("/show/{idx}").and(accept(APPLICATION_JSON)), goodsHistoryHandler::deleteByIdx);
	}
	
}
