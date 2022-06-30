package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.RunningLog;
import com.example.demo.common.jwt.JwtManager;

@RestController
@RequestMapping("/jwt")
public class JwtController {

	//@Autowired
	JwtManager jwtManager;
	
	public JwtController() {
		jwtManager = new JwtManager();
	}
	
	@RunningLog
	@GetMapping("/auth")
	public String CreateToken(@RequestParam(required = true) String userId, @RequestParam(required = true) String pw) {
		String rule = "TestUser";
		return jwtManager.generateJwtToken(userId, rule);
	}
	
	@GetMapping("/check")
	public String checkToken(@RequestHeader(value="jwt-token") String jwtToken) {
		System.out.println(jwtToken);
		return jwtManager.getUserIdFromToken(jwtToken);
	}
}
