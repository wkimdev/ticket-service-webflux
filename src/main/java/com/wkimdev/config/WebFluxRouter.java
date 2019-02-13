package com.wkimdev.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.OrderService;
import com.wkimdev.service.handler.ShowHistoryHandler;

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
	private ShowHistoryHandler showHistoryHandler;
	
	@Bean
	public RouterFunction<ServerResponse> orderServiceRouter() {
		return null;
		// 1. select 공연 내역
		// return route(GET("/show/lists").and(accept(APPLICATION_JSON)), showHistoryHandler::findById);
	}
	
}
