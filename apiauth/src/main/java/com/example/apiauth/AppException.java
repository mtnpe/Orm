package com.example.apiauth;

import lombok.Getter;

public class AppException extends RuntimeException {
	@Getter
	private int code;

	public AppException(String message) {
		this(message, 400);
	}

	public AppException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}