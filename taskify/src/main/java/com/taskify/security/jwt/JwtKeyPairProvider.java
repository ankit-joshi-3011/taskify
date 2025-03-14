package com.taskify.security.jwt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtKeyPairProvider {
	private JwtConfiguration jwtConfiguration;

	public PrivateKey getPrivateKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
		return KeyFactory.getInstance("RSA").generatePrivate(getKeySpec(jwtConfiguration.getSignaturePrivateKey()));
	}

	public PublicKey getPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
		return KeyFactory.getInstance("RSA").generatePublic(getKeySpec(jwtConfiguration.getSignaturePublicKey()));
	}

	private PKCS8EncodedKeySpec getKeySpec(String key) {
		byte[] keyBytes = Base64.getDecoder().decode(key);
		return new PKCS8EncodedKeySpec(keyBytes);
	}
}
