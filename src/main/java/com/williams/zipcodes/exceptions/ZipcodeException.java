package com.williams.zipcodes.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ZipcodeException extends Exception {

	String message;
	String info;

	private static final long serialVersionUID = 1L;

	public ZipcodeException() {
		super();
	}

	public ZipcodeException(String message) {
		this.message = message;
	}

	public ZipcodeException(String message, String info) {
		this.message = message;
		this.info = info;
	}

}
