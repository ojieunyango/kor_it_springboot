package com.packt.cardatebase;

import com.packt.cardatebase.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardatebaseApplicationTests {

	@Autowired
	private CarController controller;


	@Test
	@DisplayName("첫번째 테스트: controller 필드 생성 성공")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
