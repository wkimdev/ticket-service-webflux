package com.wkimdev.service.goods.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wkimdev.service.goods.domain.GoodsHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GoodsHistoryRepository extends ReactiveMongoRepository<GoodsHistory, String> {
	
	Flux<GoodsHistory> findAll();
	Flux<GoodsHistory> findByCategory(String category);
	Flux<GoodsHistory> findByArtist(String artist);
	
	Mono<GoodsHistory> findByIdx(String idx);
	Mono<GoodsHistory> deleteByIdx(String idx);
	
	
}
