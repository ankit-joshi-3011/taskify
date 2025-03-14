package com.taskify.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.dto.Credentials;
import com.taskify.security.service.IAuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {
	private IAuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Credentials credentials) {
		return ResponseEntity.ok(authenticationService.authenticateUser(credentials.getUsername(), credentials.getPassword()));
	}
}
