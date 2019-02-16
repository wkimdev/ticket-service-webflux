package com.wkimdev.service.goods.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * 
 * Goods Domain
 * 
 * created by wkimdev
 *
 */
@Data 
@Document(collection="goods_history")	// mongoDB , model, 각 어노테이션 의미, 적용 
public class GoodsHistory {
	
	@Id
	private String idx;
	
	private String title;
	
	/*
	 * 공연 장르
	 * 뮤지컬 : M
	 * 콘서트 : C
	 * 연극 : T
	 */
	private String category;
	
	// 대표 출연자 
	private String artist;
	
	// 공연장 
	private String place;
	
}
