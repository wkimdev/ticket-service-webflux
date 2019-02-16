package com.wkimdev.service.goods.handler;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.goods.GoodsHistoryService;
import com.wkimdev.service.goods.domain.GoodsHistory;
import com.wkimdev.service.order.domain.OrderHistory;

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
	
	/**
	 * select show list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findByIdx(ServerRequest request) {
		Mono<GoodsHistory> flux = goodsHistoryService.findByIdx(request.pathVariable("idx"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, GoodsHistory.class);
	}
	
	/**
	 * select show list by category
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findByCategory(ServerRequest request) {
		Flux<GoodsHistory> flux = goodsHistoryService.findByCategory(request.pathVariable("category"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, GoodsHistory.class);
	}
	
	/**
	 * select show list by category
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findByArtist(ServerRequest request) {
		Flux<GoodsHistory> flux = goodsHistoryService.findByArtist(request.pathVariable("artist"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, GoodsHistory.class);
	}
	
	/**
	 * add show list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> save(ServerRequest request) {
		Mono<GoodsHistory> mono = request.bodyToMono(GoodsHistory.class).flatMap(mapper -> goodsHistoryService.save(mapper));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mono, GoodsHistory.class);
    }
	
	/**
	 * delete show by id
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> deleteByIdx(ServerRequest request) {
		String idx = request.pathVariable("idx");
		Mono<GoodsHistory> mono = goodsHistoryService.deleteByIdx(idx);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mono, GoodsHistory.class);
    }

}
