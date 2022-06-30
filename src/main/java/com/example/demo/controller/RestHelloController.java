package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Work;

@RestController
@RequestMapping("/api")
public class RestHelloController {
	/**
	 * aaaa
	 */
	@GetMapping("/test")
	public String apiWorkGet(@RequestParam String name) {
		
		return "get 요청 => /api/hello name => %s".formatted(name == null ? "[null data]" : name);
	}
	
	@GetMapping("/test/{id}")
	public String apiWorkGetId(@PathVariable(value="id") String id) {
			
		return "get 요청 => /api/hello param id => %s".formatted(id);
	}
	
	@PostMapping("/test") 
	public String apiWorkPost() {
		return "post 요청 => /api/hello";
	}
	
	@GetMapping("/tests") 
	public ResponseEntity<List<Work>> apiWorkGet() {
		List<Work> data = new ArrayList<Work>();
		Work data1 = new Work();
		data1.setWorkName("작업1");
		data1.setWorkNumber(0);
		data.add(data1);
		
		
		return new ResponseEntity<List<Work>>(data, HttpStatus.OK );
	}
}
