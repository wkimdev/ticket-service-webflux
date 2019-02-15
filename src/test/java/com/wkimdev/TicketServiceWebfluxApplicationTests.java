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

import com.wkimdev.service.goods.domain.GoodsHistory;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketServiceWebfluxApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;
	
//	@Test
	public void contextLoads() {
	}
	
	@Test
	public void showFindAllTest() {
		ResponseSpec responseSpec = webTestClient.get()
												 .uri("/show/lists")
												 .exchange()
												 .expectStatus().isOk();
		ParameterizedTypeReference<List<GoodsHistory>> typeReference = new ParameterizedTypeReference<List<GoodsHistory>>() {};
		System.out.println("11 22 "+responseSpec);
		System.out.println(responseSpec.returnResult(typeReference));
	}

}

