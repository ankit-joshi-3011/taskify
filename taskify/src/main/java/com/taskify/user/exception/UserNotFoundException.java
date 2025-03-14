package com.taskify.user.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6090763149641756560L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
