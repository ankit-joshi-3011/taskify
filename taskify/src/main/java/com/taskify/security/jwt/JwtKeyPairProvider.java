package com.taskify.security.jwt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtKeyPairProvider {
	private JwtConfiguration jwtConfiguration;

	public PrivateKey getPrivateKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = Base64.getDecoder().decode(jwtConfiguration.getSignaturePrivateKey());
		return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
	}

	public PublicKey getPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] keyBytes = Base64.getDecoder().decode(jwtConfiguration.getSignaturePublicKey());
		return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(keyBytes));
	}
}
