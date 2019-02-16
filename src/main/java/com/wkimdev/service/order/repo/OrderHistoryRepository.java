package com.wkimdev.service.order.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wkimdev.service.order.domain.OrderHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderHistoryRepository extends ReactiveMongoRepository<OrderHistory, String> {

	Flux<OrderHistory> findAll();
	Flux<OrderHistory> findByIdx(String idx);
	
	Mono<OrderHistory> save(OrderHistory entity);

	
}
