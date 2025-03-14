package com.taskify.security.service;

public interface IAuthenticationService {
	String authenticateUser(String username, String password);
}
