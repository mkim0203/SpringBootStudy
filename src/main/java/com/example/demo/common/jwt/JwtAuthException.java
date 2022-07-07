package com.example.demo.common.jwt;

/**
 * 잘못된 jwt id/pw 정보 받앗을때 처리용
 * @author mkim
 *
 */
public class JwtAuthException extends RuntimeException {
	public JwtAuthException(String userId) {
		super("jwt 인증을 실패했습니다. [" + userId + "]");
	}
}
