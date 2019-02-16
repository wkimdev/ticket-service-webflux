package com.wkimdev.service.goods;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wkimdev.service.goods.domain.GoodsHistory;
import com.wkimdev.service.goods.repo.GoodsHistoryRepository;
import com.wkimdev.service.order.domain.OrderHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("GoodsHistoryService")
public class GoodsHistoryService {
	
	@Autowired
	private GoodsHistoryRepository goodsHistoryRepository; 
		
	/*
	 * find all show list
	 * @return Flux<GoodsHistory> 
	 */
	public Flux<GoodsHistory> findAll(){
		return goodsHistoryRepository.findAll();
	}
	
	/*
	 * find all show list by show Id
	 * @return Flux<GoodsHistory> 
	 */
	public Mono<GoodsHistory> findByIdx(String idx) {
		return goodsHistoryRepository.findByIdx(idx);
	}
	
	/*
	 * find all show list by show category
	 * @return Flux<GoodsHistory> 
	 */
	public Flux<GoodsHistory> findByCategory(String category) {
		return goodsHistoryRepository.findByCategory(category);
	}
	
	/*
	 * find all show list by show artist
	 * @return Flux<GoodsHistory> 
	 */
	public Flux<GoodsHistory> findByArtist(String artist) {
		return goodsHistoryRepository.findByArtist(artist);
	}
	
	/**
	 * create document
	 * @param show(goods) add  
	 * @return Mono<OrderHistory>
	 */
	public Mono<GoodsHistory> save(GoodsHistory goodsHistory) {
		String idx = "GOODS-"+UUID.randomUUID().toString();
		goodsHistory.setIdx(idx);
		return goodsHistoryRepository.save(goodsHistory);
	}

	public Mono<GoodsHistory> deleteByIdx(String idx) {
		return goodsHistoryRepository.deleteByIdx(idx);
	}


	
}
