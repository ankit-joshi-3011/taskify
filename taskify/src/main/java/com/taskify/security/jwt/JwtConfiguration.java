package com.taskify.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtConfiguration {
	private String signaturePrivateKey;
	private String signaturePublicKey;
	private long expiration;
}
