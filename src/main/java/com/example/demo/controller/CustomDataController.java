package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.Settings;
import com.example.demo.common.model.settings.Appsetting;

@RestController
@RequestMapping("/custom-data")
public class CustomDataController {

	@Value("${customData.projectName}")
	String projectName;
	
	@Value("${customData.projectDocument}")
	String projectDocument;
	
	@GetMapping("/project-name")
	public String getProjectName() {
		return projectName;
	}
	
	@GetMapping("/project-document")
	public String getProjectDocument() {
		return projectDocument;
	}
	
	@Autowired
	Settings setting;
	
	@GetMapping("/setting")
	public Settings getSettings() {
		System.out.println(setting);
		return setting;
	}
	
	@Autowired
	Appsetting setting2;
	
	@GetMapping("/setting2") 
	public Appsetting getSettings2() {
		return setting2;
	}
}
