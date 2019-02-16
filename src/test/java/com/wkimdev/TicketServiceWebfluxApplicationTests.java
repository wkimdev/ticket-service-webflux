package com.wkimdev;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import org.springframework.web.reactive.function.BodyInserters;

import com.wkimdev.service.goods.domain.GoodsHistory;
import com.wkimdev.service.order.domain.OrderHistory;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketServiceWebfluxApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;
	
//	@Test
	public void contextLoads() {
	}
	
//	@Test
	public void showFindAllTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/show/lists")
												 .exchange()
												 .expectStatus().isOk();
		ParameterizedTypeReference<List<GoodsHistory>> typeReference = new ParameterizedTypeReference<List<GoodsHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
	@Test
	public void orderFindAllTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/order/history")
												 .exchange()
												 .expectStatus().isOk();
		ParameterizedTypeReference<List<OrderHistory>> typeReference = new ParameterizedTypeReference<List<OrderHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
//	@Test
	public void orderSaveTest() {
		
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setIdx(1);
		orderHistory.setUserUuId("test_user");
		orderHistory.setReserveDate("20190101");
		
		webTestClient.post()
						 .uri("/order/history")
						 .body(BodyInserters.fromObject(orderHistory))
						 .exchange()
						 .expectStatus().isOk();
			
	}
	
//	@Test
	public void showSaveTest() {
		
		GoodsHistory goodsHistory = new GoodsHistory();
		goodsHistory.setIdx(1);
		goodsHistory.setTitle("잠실콘서트");
		goodsHistory.setCategory("concert");
		goodsHistory.setPerformancer("박효신");
		goodsHistory.setPlace("올림픽대공원");
		
		webTestClient.post()
						 .uri("/show/lists")
						 .body(BodyInserters.fromObject(goodsHistory))
						 .exchange()
						 .expectStatus().isOk();
	}
	
//	@Test
	public void buyFlagUpdateTest() {
		
		// where 문 어떻게???
		// 1. select 
		// select 한 id를 받아서 where구문에 넣고 update
		// id를 따로 response 받아서 처리해야지.
		
		// spring data entity가 id를 정의해놓았기 때문에 그걸 where 문 처리처럼 update하게 해줌. 
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setIdx(1);
		orderHistory.setBuyFlag(1);
		// 현재 시간 add
		orderHistory.setBuyDate("190216");
		
		webTestClient.post()
						 .uri("/order/complete")
						 .body(BodyInserters.fromObject(orderHistory))
						 .exchange()
						 .expectStatus().isOk();
		
	}
	
}

