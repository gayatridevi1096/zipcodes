package com.williams.zipcodes.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZipcodeExceptionTest {

	@Test
	public void testNoArgs() {
		ZipcodeException exception = new ZipcodeException();
		Assertions.assertNotNull(exception);
	}

	@Test
	public void testOneArgs() {
		ZipcodeException exception = new ZipcodeException("sample");
		Assertions.assertNotNull(exception);
	}

	@Test
	public void testTwoArgs() {
		ZipcodeException exception = new ZipcodeException("sample", "sample1");
		Assertions.assertNotNull(exception);
	}
}
