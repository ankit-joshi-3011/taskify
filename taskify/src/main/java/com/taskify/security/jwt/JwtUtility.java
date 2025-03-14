package com.taskify.security.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
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

	public String extractUsername(String jwt) throws JwtException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
		return extractClaim(jwt, Claims::getSubject);
	}

	private <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) throws JwtException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
		Claims claims = extractAllClaims(jwt);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String jwt) throws JwtException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
		return Jwts.parser()
			.verifyWith(jwtKeyPairProvider.getPublicKey())
			.build()
			.parseSignedClaims(jwt)
			.getPayload();
	}
}
