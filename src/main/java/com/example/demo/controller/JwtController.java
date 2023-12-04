package com.example.demo.controller;

import com.example.demo.common.model.ResultCode;
import com.example.demo.common.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.NeedToken;
import com.example.demo.common.aop.RunningLog;
import com.example.demo.common.jwt.JwtAuthException;
import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.jwt.JwtManager;
import com.example.demo.model.User;
import com.example.demo.service.IAuthService;

import java.util.HashMap;
import java.util.Map;

/**
 * jwt 인증관련
 * 
 * @author mkim
 *
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {

	@Autowired
	JwtManager jwtManager;

	@Autowired
	IAuthService authService;

	public JwtController() {
		//jwtManager = new JwtManager();
	}

	/**
	 * jwt 인증 token 생성
	 * 
	 * @param userId
	 * @param pw
	 * @return
	 */
	@RunningLog
	@GetMapping("/auth")
	public Map<String, Object> CreateToken(@RequestParam(required = true) String userId, @RequestParam(required = true) String pw) {
		Map<String, Object> retValue = new HashMap<>();
		String rule = "TestUser";

		User userInfo = new User(userId, pw);

		if (authService.checkUser(userInfo)) {
			String token = jwtManager.generateJwtToken(userId, rule);
			retValue.put("token", token);
//			return jwtManager.generateJwtToken(userId, rule);
			return retValue;
		}
		else {
			// 잘못된 인증 으로 처리.
			throw new JwtAuthException(userId);
		}
	}

	@GetMapping("/check")
	@NeedToken
	public ResultModel<Boolean> checkToken(@RequestHeader(value = "jwt-token", required = false) String jwtToken) {
		System.out.println(jwtToken);
		ResultModel<Boolean> retValue = new ResultModel<>();
		String userId = jwtManager.getUserIdFromToken(jwtToken);

		retValue.setCode(ResultCode.SUCCESS);
//		retValue.setCode("Success");
		retValue.setData(true);
		return retValue;

//		return jwtManager.getUserIdFromToken(jwtToken);
	}
}
