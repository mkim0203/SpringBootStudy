package com.example.demo.common.jwt;

/**
 * 잘못된 token 시 오류 처리용
 * @author mkim
 *
 */
public class JwtException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9117526285856967L;

	public JwtException() {
		super("jwt token 정보가 잘못되었습니다.");
	}
}
