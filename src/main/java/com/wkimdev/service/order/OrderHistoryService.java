package com.wkimdev.service.order;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkimdev.service.order.domain.OrderHistory;
import com.wkimdev.service.order.repo.OrderHistoryRepository;
import com.wkimdev.util.CommonUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("OrderHistoryService")
public class OrderHistoryService {
	
	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	
	/**
	 * order history list 
	 * @param OrderHistory
	 * @return Mono<OrderHistory>
	 */
	public Flux<OrderHistory> findAll() {
		return orderHistoryRepository.findAll();
	}
	
	public Flux<OrderHistory> findByIdx(String idx) {
		return orderHistoryRepository.findByIdx(idx);
	}
	
	/**
	 * create document
	 * @param OrderHistory
	 * @return Mono<OrderHistory>
	 */
	public Mono<OrderHistory> save(OrderHistory orderHistory) {
		String idx = "ODNUM-" + UUID.randomUUID().toString();
		
		orderHistory.setIdx(idx);
		orderHistory.setReserveDate(CommonUtil.getDate());
		return orderHistoryRepository.save(orderHistory);
	}
	
	/**
	 * update document
	 * @param OrderHistory
	 * @return Mono<OrderHistory>
	 */
	public Mono<OrderHistory> update(OrderHistory orderHistory) {
		orderHistory.setBuyDate(CommonUtil.getDate());
		return orderHistoryRepository.save(orderHistory);
	}

}
