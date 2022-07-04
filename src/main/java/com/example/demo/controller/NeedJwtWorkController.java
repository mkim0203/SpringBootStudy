package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.NeedToken;


@RestController
@RequestMapping("/jwt-required")
@NeedToken
public class NeedJwtWorkController extends WorkController {
	private final Logger logger = LoggerFactory.getLogger(NeedJwtWorkController.class);
	
	//@NeedToken
	@GetMapping("/test")
	public String test() {
		logger.info("테스트 INFO log");
		return "test";
	}
}
