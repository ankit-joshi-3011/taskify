package com.taskify.security.jwt.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.taskify.security.jwt.JwtUtility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
	private JwtUtility jwtUtility;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String[] authHeaderParts = authHeader.split("\\s");
			String jwt = authHeaderParts[1];

			String username = null;
			boolean isTokenValid = false;

			try {
				username = jwtUtility.extractUsername(jwt);
				isTokenValid = jwtUtility.validateToken(jwt);
			} catch (Exception e) {
				// Simply pass the request to the next filter
			}

			if (username != null && isTokenValid && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = User.withUsername(username)
					.password("")
					.build();

				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
			}
		}

		filterChain.doFilter(request, response);
	}
}
