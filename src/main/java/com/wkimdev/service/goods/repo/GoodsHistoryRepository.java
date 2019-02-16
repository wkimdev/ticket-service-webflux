package com.wkimdev.service.goods.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wkimdev.service.goods.domain.GoodsHistory;

import reactor.core.publisher.Flux;

public interface GoodsHistoryRepository extends ReactiveMongoRepository<GoodsHistory, String> {
	
	Flux<GoodsHistory> findAll();
	
	//findByI
}
