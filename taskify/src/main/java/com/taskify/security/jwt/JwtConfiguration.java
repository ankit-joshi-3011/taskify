package com.taskify.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@ConfigurationProperties(prefix = "jwt")
@Getter
public class JwtConfiguration {
	private String secretKey;
	private long expiration;
}
