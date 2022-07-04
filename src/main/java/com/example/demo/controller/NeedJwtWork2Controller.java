package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.NeedToken;

import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jwt-required-v2")
@NeedToken
public class NeedJwtWork2Controller {

	/**
	 * swagger jwt-token header 항목 추가 @ApiImplicitParam 사용하여 처리함.
	 */
	@GetMapping("/test")
	@ApiImplicitParam(name = "jwt-token", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "token 문자열 입력")
	public String test() {
		log.info("log 추가 테스트");
		
		return "test";
	}
}
