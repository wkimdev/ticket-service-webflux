package com.wkimdev.service.order.domain;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data 
@Document(collection="order_history")
public class OrderHistory {
	
	@Id
	private int idx;
	
	private String userUuId;
	
	// 예약 날짜
	private String reserveDate;
	
	// 아이템넘버 
	private int goodsNum;
		
	/*
	 * 구매 여부 플래그
	 * 1 : buy completed
	 * 2 : not completed
	 * 3 : error
	 */
	private int buyFlag;
	
	private String buyDate;
	
}
