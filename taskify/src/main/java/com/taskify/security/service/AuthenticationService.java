package com.taskify.security.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskify.entity.User;
import com.taskify.security.exception.TokenGenerationException;
import com.taskify.security.jwt.JwtUtility;
import com.taskify.user.exception.InvalidPasswordException;
import com.taskify.user.exception.UserNotFoundException;
import com.taskify.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService implements IAuthenticationService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtUtility jwtUtility;

	@Override
	public String authenticateUser(String username, String password) {
		Optional<User> user = userRepository.findByUsername(username);

		if (user.isEmpty()) {
			throw new UserNotFoundException("Invalid username or password");
		}
		
		if (!passwordEncoder.matches(password, user.get().getPassword())) {
			throw new InvalidPasswordException("Invalid username or password");
		}
		
		try {
			return jwtUtility.generateToken(username);
		} catch (Exception e) {
			throw new TokenGenerationException("Internal server error during authentication");
		}
	}
}
