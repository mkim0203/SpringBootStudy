package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.Settings;
import com.example.demo.common.model.settings.Appsetting;

import java.util.HashMap;
import java.util.Map;

@Api(tags="추가 설정 조회")
@RestController
@RequestMapping("/application-properties")
public class CustomDataController {

	@Value("${customData.projectName}")
	String projectName;
	
	@Value("${customData.projectDocument}")
	String projectDocument;
	
//	@GetMapping("/project-name")
//	public String getProjectName() {
//		return projectName;
//	}


	@ApiOperation(value="projectName 조회", notes="custom data projectName 조회")
	@GetMapping("/project-name")
	public Map<String, Object> GetProjectNameJson() {
		Map<String, Object> retValue = new HashMap<String, Object>();
		retValue.put("projectName", projectName);

		return retValue;
	}

//	@GetMapping("/project-document")
//	public String getProjectDocument() {
//		return projectDocument;
//	}

	@ApiOperation(value="projectDocument 조회", notes="custom data projectDocument 조회")
	@GetMapping("/project-document")
	public Map<String, Object> getProjectDocumentJson() {
		Map<String, Object> retValue = new HashMap<>();
		retValue.put("projectDocument", projectDocument);
		return retValue;
	}
	
	@Autowired
	Settings setting;

	@ApiOperation(value="서버 설정 조회", notes="서버 설정 조회")
	@GetMapping("/servers")
	public Settings getSettings() {
		System.out.println(setting);
		return setting;
	}

	
	@Autowired
	Appsetting setting2;

	@ApiOperation(value="App 설정 조회", notes="App 설정 조회")
	@GetMapping("/app-settings")
	public Appsetting getSettings2() {
		return setting2;
	}
}
