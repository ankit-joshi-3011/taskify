package com.taskify.user.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.taskify.entity.User;
import com.taskify.user.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private IUserService userService;

	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<User> save(@RequestBody User user) {
		User savedUser = userService.save(user);

		URI savedUserLocation = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.replacePath("/api/users")
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();

		return ResponseEntity.created(savedUserLocation).build();
	}
}
