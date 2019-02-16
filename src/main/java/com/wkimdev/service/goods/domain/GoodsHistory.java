package com.wkimdev.service.goods.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data 
@Document(collection="goods_history")	// mongoDB , model, 각 어노테이션 의미, 적용 
public class GoodsHistory {
	
	//@Id ObjectId databaseId;
	@Id
	private int idx;
	
	// 아이템넘버 
	private int goodsNum;
	
	private String title;
	
	// 공연 장르 : 뮤지컬, 콘서트, 연극 etc  
	private String category;
	
	// 대표 출연자 
	private String performancer;
	
	// 공연장 
	private String place;
	
}
