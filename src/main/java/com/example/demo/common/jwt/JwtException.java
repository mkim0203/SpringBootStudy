package com.example.demo.common.jwt;

public class JwtException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9117526285856967L;

	public JwtException() {
		super("jwt token 정보가 잘못되었습니다.");
	}
}
