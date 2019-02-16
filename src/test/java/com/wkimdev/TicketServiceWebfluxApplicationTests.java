package com.wkimdev;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
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
	
//	@Test
	public void showFindByIdTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/show/lists/2")
												 .exchange()
												 .expectStatus().isOk();
										
		ParameterizedTypeReference<List<GoodsHistory>> typeReference = new ParameterizedTypeReference<List<GoodsHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
//	@Test
	public void showFindByCategoryTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/show/category/M")
												 .exchange()
												 .expectStatus().isOk();
										
		ParameterizedTypeReference<List<GoodsHistory>> typeReference = new ParameterizedTypeReference<List<GoodsHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
//	@Test
	public void showFindByArtistTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/show/artist/옥주현")
												 .exchange()
												 .expectStatus().isOk();
										
		ParameterizedTypeReference<List<GoodsHistory>> typeReference = new ParameterizedTypeReference<List<GoodsHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
//	@Test
	public void orderFindByIdTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/order/history/ODNUM-3dae5938-ef19-4522-bb45-ec9573c39f49")
												 .exchange()
												 .expectStatus().isOk();
										
		ParameterizedTypeReference<List<OrderHistory>> typeReference = new ParameterizedTypeReference<List<OrderHistory>>() {};
		System.out.println(responseSpec.returnResult(typeReference));
	}
	
//	@Test
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
		orderHistory.setUserId("wkimdev");
		orderHistory.setGoodsId("GOODS-79604901-6729-4862-a872-697a89c90e2a");
		
		webTestClient.post()
						 .uri("/order/history")
						 .body(BodyInserters.fromObject(orderHistory))
						 .exchange()
						 .expectStatus().isOk();
			
	}
	
//	@Test
	public void showSaveTest() {
		
		GoodsHistory goodsHistory = new GoodsHistory();
		goodsHistory.setTitle("레베카");
		goodsHistory.setCategory("M"); 
		goodsHistory.setArtist("옥주현");
		goodsHistory.setPlace("삼성역스퀘어");
		
		webTestClient.post()
						 .uri("/show/lists")
						 .body(BodyInserters.fromObject(goodsHistory))
						 .exchange()
						 .expectStatus().isOk();
	}
	
//	@Test
	public void buyFlagUpdateTest() {
		// spring data entity가 id를 정의해놓았기 때문에 그걸 where 문 처리처럼 update하게 해줌.
		// update인데 request parameter들을 다 맵핑 해줘야 된다???
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setIdx("ODNUM-3dae5938-ef19-4522-bb45-ec9573c39f49");
		orderHistory.setUserId("wkimdev");
		orderHistory.setReserveDate("2019-02-16 10:17:16");
		orderHistory.setGoodsId("GOODS-79604901-6729-4862-a872-697a89c90e2a");
		orderHistory.setBuyFlag(2);
		
		// put 요청 : 요청 방식 post 시 no matching handler 에러!
		webTestClient.put()
					 .uri("/order/complete")
					 .body(BodyInserters.fromObject(orderHistory))
					 .exchange()
					 .expectStatus().isOk();
		
	}
	
	@Test
	public void deleteShowTest() {
		webTestClient.delete()
					 .uri("/show/1")
					 .exchange()
					 .expectStatus().isOk();
	}
	
//	@Test
	public void httpMethodErrorTest() {
		// "message":"No matching handler"
		ResponseSpec responseSpec = webTestClient.post()
												 .uri("show/lists/4")
												 .exchange()
												 .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
		System.out.println(responseSpec.returnResult(GoodsHistory.class));
	}
	
//	@Test
	public void dateTest() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		
		String reserveDate = date.format(today) + " " + time.format(today);
		System.out.println(reserveDate);
	}
	
}

