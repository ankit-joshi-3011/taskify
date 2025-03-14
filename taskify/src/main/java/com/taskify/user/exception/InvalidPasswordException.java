package com.taskify.user.exception;

public class InvalidPasswordException extends RuntimeException {
	private static final long serialVersionUID = -4639985970706883259L;

	public InvalidPasswordException(String message) {
		super(message);
	}
}
