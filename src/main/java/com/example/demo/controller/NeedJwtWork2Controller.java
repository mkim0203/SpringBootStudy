package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.aop.NeedTokenInController;

@RestController
@RequestMapping("/jwt-required-v2")
@NeedTokenInController
public class NeedJwtWork2Controller {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
