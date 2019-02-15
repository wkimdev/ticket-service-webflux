package com.wkimdev.service.goods;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wkimdev.service.goods.domain.GoodsHistory;
import com.wkimdev.service.goods.repo.GoodsHistoryRepository;

import reactor.core.publisher.Flux;

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
	
}
