package com.taskify.security.exception;

public class TokenGenerationException extends RuntimeException {
	private static final long serialVersionUID = 1278852896649412896L;

	public TokenGenerationException(String message) {
		super(message);
	}
}
