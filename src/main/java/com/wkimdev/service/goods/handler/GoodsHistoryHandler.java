package com.wkimdev.service.goods.handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.goods.GoodsHistoryService;
import com.wkimdev.service.goods.domain.GoodsHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * webflux use handler instead controller
 * 
 */
@Component
public class GoodsHistoryHandler {
	
	@Autowired
	private GoodsHistoryService goodsHistoryService;
	
	/**
	 * select show list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findAll(ServerRequest request) {
		Flux<GoodsHistory> flux = goodsHistoryService.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, GoodsHistory.class);
	}
}
