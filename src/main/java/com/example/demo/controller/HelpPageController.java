package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HelpPageController {
	@GetMapping("/config/swagger")
	//@RequestMapping("/api/swagger")
	public View swaggerPage() {
		// spring boot 일정 버전이상부터는 RedirectView 사용해서 해야함.
		//return "redirect:/swagger-ui/index.html";	
		return new RedirectView("/swagger-ui/index.html");
	}
	
	@GetMapping("/config/h2db")
	//@RequestMapping("/api/h2db")
	public View H2Db() {
		return new RedirectView("/h2-console");
		//return "redirect:/h2-console"; 
	}
}
