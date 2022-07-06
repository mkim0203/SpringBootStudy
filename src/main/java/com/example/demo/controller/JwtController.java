package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.NeedToken;
import com.example.demo.common.aop.RunningLog;
import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.jwt.JwtManager;

/**
 * jwt 인증관련
 * @author mkim
 *
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {

	//@Autowired
	JwtManager jwtManager;
	
	public JwtController() {
		jwtManager = new JwtManager();
	}
	
	/**
	 * jwt 인증 token 생성
	 * @param userId
	 * @param pw
	 * @return
	 */
	@RunningLog
	@GetMapping("/auth")
	public String CreateToken(@RequestParam(required = true) String userId, @RequestParam(required = true) String pw) {
		String rule = "TestUser";
		return jwtManager.generateJwtToken(userId, rule);
	}
	
	@GetMapping("/check")
	@NeedToken
	public String checkToken(@RequestHeader(value="jwt-token", required = false) String jwtToken) {
		System.out.println(jwtToken);
		return jwtManager.getUserIdFromToken(jwtToken);
	}
}
