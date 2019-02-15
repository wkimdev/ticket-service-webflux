package com.wkimdev.service.goods.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data 
@Document(collection="goods_history")	// mongoDB , model, 각 어노테이션 의미, 적용 
public class GoodsHistory {
	
	//@Id
	
	private String title;
	
	private String reserveDate;
}
