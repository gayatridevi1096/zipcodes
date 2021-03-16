package com.williams.zipcodes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.williams.zipcodes.controllers.ZipcodeController;

@SpringBootTest
class ShipmentZipcodesApplicationTests {


@Autowired ZipcodeController zipcodController;

	@Test
	void contextLoads() {
		assertThat(zipcodController).isNotNull();
	}
}
