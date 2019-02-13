package com.wkimdev.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wkimdev.service.OrderService;

import reactor.core.publisher.Mono;

/**
 * 
 * webflux use handler instead controller
 * 
 */
@Component
public class ShowHistoryHandler {
	
	@Autowired
	private OrderService orderService;
	
	//  
	/**
	 * select show list
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> findById(ServerRequest request) {
//		String txId = request.pathVariable("txId");
//		Mono<TransferHistory> result = transferHistoryService.getTransferHistoryByTxId(txId);
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, TransferHistory.class);
		return null;
	}
}
