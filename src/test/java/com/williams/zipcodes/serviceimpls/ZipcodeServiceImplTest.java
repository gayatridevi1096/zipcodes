package com.williams.zipcodes.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.williams.zipcodes.exceptions.ZipcodeException;
import com.williams.zipcodes.services.ZipcodeService;

@SpringBootTest
public class ZipcodeServiceImplTest {

	@Autowired
	ZipcodeService zipCodeservice;

	@Test
	public void testZincodeMinRangeCalculatorPositive() throws ZipcodeException {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94699 });
		Assertions.assertTrue(zipCodeservice.zipcodesMinimumRange(test).size() > 0);
		Assertions.assertEquals(2, zipCodeservice.zipcodesMinimumRange(test).size());
	}

	@Test
	public void testZincodeMinRangeCalculatorNeutral() throws ZipcodeException {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 94133, 94133 });
		test.add(new Integer[] { 94200, 94299 });
		test.add(new Integer[] { 94226, 94399 });
		Assertions.assertTrue(zipCodeservice.zipcodesMinimumRange(test).size() > 0);
		Assertions.assertEquals(94133, zipCodeservice.zipcodesMinimumRange(test).get(0)[0]);
	}

	@Test
	public void testZincodeMinRangeCalculatorNeutral2() throws ZipcodeException {
		List<Integer[]> test = new ArrayList<>();
		test.add(new Integer[] { 3, 6 });
		test.add(new Integer[] { 1, 4 });
		test.add(new Integer[] { 5, 12 });
		test.add(new Integer[] { 4, 8 });
		Assertions.assertTrue(zipCodeservice.zipcodesMinimumRange(test).size() > 0);
		Assertions.assertEquals(1, zipCodeservice.zipcodesMinimumRange(test).size());
	}

}
