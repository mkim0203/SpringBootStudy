package com.example.demo.common.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@PropertySource(value = "application.properties")
@Component
public class JwtManager {
	@Value("${jwt.key}")
	String securityKey;

	public String generateJwtToken(String userId, String role) {
		System.out.println(securityKey);
		Date now = new Date();
		// 유효시간
		long expiredTime = 1000 * 60L * 30L;
		return Jwts.builder().setSubject(userId) // 보통 username
				.setHeader(createHeader()).setClaims(createClaims(userId, role)) // 클레임, 토큰에 포함될 정보
				.setExpiration(new Date(now.getTime() + expiredTime)) // 만료일
				.signWith(SignatureAlgorithm.HS256, securityKey).compact();
	}

	private Map<String, Object> createHeader() {
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256"); // 해시 256 사용하여 암호화
		header.put("regDate", System.currentTimeMillis());
		return header;
	}

	/**
	 * 클레임(Claim)을 생성한다.
	 *
	 */
	private Map<String, Object> createClaims(String userId, String role) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", userId); //
		claims.put("roles", role); // 인가정보
		return claims;
	}

	/**
	 * Token 에서 Claim 을 가져온다.
	 *
	 * @param token JWT 토큰
	 * @return Claims 클레임
	 */
	private Claims getClaims(String token) {
		System.out.println("run Claims");
		System.out.println("securityKey =>" +securityKey);
		return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
	}

	public void checkJwtToken(String token) {
		try {
			getClaims(token);
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new JwtException();
		}
	}

	/**
	 * 토큰으로 부터 username 을 가져온다.
	 *
	 * @param token JWT 토큰
	 * @return String Member 의 username
	 */
	public String getUserIdFromToken(String token) {
		return (String) getClaims(token).get("userId");
	}

	/**
	 * 토큰으로 부터 인가 정보를 가져온다.
	 *
	 * @param token JWT 토큰
	 * @return Set<MemberRole> role 정보를 가지고 있는 Set
	 */
	public String getMemberRoleSetFromToken(String token) {
		return (String) getClaims(token).get("roles");
	}

}
