package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.BaseResultModel;
import com.example.demo.model.DataNotFoundException;

@RestController
@RequestMapping("/test")
public class TestExceptionController {
	@GetMapping("/not-found")
	public BaseResultModel notFoundRequest() {
		throw new DataNotFoundException("test");
	}
	
	@GetMapping("/exception")
	public BaseResultModel exceptionRequest() throws Exception {
		throw new Exception("Test");
	}
}
