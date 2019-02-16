package com.wkimdev.service.order.domain;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 
 * Order Domain
 * 
 * created by wkimdev
 *
 */
@Data 
@Document(collection="order_history")
public class OrderHistory {
	
	@Id
	private String idx;
	
	private String userId;
	
	private String reserveDate;
	
	// goods id 
	private String goodsId;
		
	/*
	 * 구매 여부 플래그
	 * 1 : buy completed
	 * 2 : not completed
	 * 3 : error
	 */
	private int buyFlag;
	
	private String buyDate;
	
}
