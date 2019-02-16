package com.wkimdev.service.order.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.goods.domain.GoodsHistory;
import com.wkimdev.service.order.OrderHistoryService;
import com.wkimdev.service.order.domain.OrderHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * webflux use handler instead controller
 * 
 */
@Component
public class OrderHistoryHandler {
	
	@Autowired
	private OrderHistoryService orderHistoryService; 
	
	/**
	 * select order list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findAll(ServerRequest request) {
		Flux<OrderHistory> flux = orderHistoryService.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, OrderHistory.class);
	}
	
	/**
	 * select order list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findByIdx(ServerRequest request) {
		Flux<OrderHistory> flux = orderHistoryService.findByIdx(request.pathVariable("idx"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux, OrderHistory.class);
	}
	
	
	/**
	 * save document
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> save(ServerRequest request) {
		Mono<OrderHistory> result = request.bodyToMono(OrderHistory.class).flatMap(mapper -> orderHistoryService.save(mapper));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, OrderHistory.class);
    }
	
	/**
	 * update document
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> update(ServerRequest request) {
		Mono<OrderHistory> result = request.bodyToMono(OrderHistory.class).flatMap(mapper -> orderHistoryService.update(mapper));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, OrderHistory.class);
    }
	
}
