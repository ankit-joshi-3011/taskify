package com.taskify.security.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtUtility {
	private JwtKeyPairProvider jwtKeyPairProvider;
	private JwtConfiguration jwtConfiguration;

	public String generateToken(String userName) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException {
		long currentSystemTime = System.currentTimeMillis();

		return Jwts.builder()
			.claims()
			.subject(userName)
			.and()
			.issuedAt(new Date(currentSystemTime))
			.expiration(new Date(currentSystemTime + jwtConfiguration.getExpiration()))
			.signWith(jwtKeyPairProvider.getPrivateKey(), Jwts.SIG.RS256)
			.compact();
	}
}
