package com.taskify.user.service;

import org.springframework.stereotype.Service;

import com.taskify.entity.User;
import com.taskify.user.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
