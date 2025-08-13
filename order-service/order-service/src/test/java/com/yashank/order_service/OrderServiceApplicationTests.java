package com.yashank.order_service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import io.restassured.RestAssured;
import lombok.var;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.3.0");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJson = """
									{
									"skuCode" : "Iphone_12",
									"price" : 100000,
									"quantity" : 100  
									}
								""";
		var responseBodyString = RestAssured.given()
		.contentType("application/json")
		.body(submitOrderJson)
		.when()
		.post("/api/order/place_order")
		.then()
		.log().all()
		.statusCode(201)
		.extract()
		.body().asString();

		assertThat(responseBodyString,Matchers.is("Order Placed Successfully"));
	}

}
