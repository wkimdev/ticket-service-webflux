package com.wkimdev.service.goods;

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
	 * select show list
	 * @return Flux<GoodsHistory> 
	 */
	public Flux<GoodsHistory> findAll(){
		return goodsHistoryRepository.findAll();
	}
	
	/**
	 * create document
	 * @param show(goods) add  
	 * @return Mono<OrderHistory>
	 */
	public Mono<GoodsHistory> save(GoodsHistory goodsHistory) {
		return goodsHistoryRepository.save(goodsHistory);
	}
	
}
