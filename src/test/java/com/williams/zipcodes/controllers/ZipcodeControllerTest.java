package com.williams.zipcodes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ZipcodeControllerTest {

	@Autowired
	private ZipcodeController zipcodeController;

	@Test
	public void test() throws Exception {

		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		ResponseEntity<List<Integer[]>> entity = zipcodeController.zipcodesMinRange(test);
		Assertions.assertEquals(200, entity.getStatusCodeValue());
	}

	@Test
	public void testResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		ResponseEntity<List<Integer[]>> entity = zipcodeController.zipcodesMinRange(test);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertEquals(response.get(0)[0], entity.getBody().get(0)[0]);
		Assertions.assertEquals(response.get(1)[1], entity.getBody().get(1)[1]);
	}

	@Test
	public void testNegativeResponse() throws Exception {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		ResponseEntity<List<Integer[]>> entity = zipcodeController.zipcodesMinRange(test);
		List<Integer[]> response = new ArrayList<>();
		response.add(new Integer[] { 94133, 94133 });
		response.add(new Integer[] { 94200, 94699 });
		Assertions.assertNotEquals(response, entity.getBody());
	}

}
