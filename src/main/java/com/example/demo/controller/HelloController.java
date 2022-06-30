package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HelloController {
	@RequestMapping("/hello")
	  public @ResponseBody String hello() {
	    return "Hello, Spring Boot!";
	  }
}
