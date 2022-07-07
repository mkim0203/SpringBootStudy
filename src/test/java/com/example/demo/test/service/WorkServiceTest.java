package com.example.demo.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.WorkService;
import com.example.demo.test.BaseTest;

@SpringBootTest
public class WorkServiceTest extends BaseTest {

	@Autowired
	WorkService workService;

	@Test
	public void getAll() {
		var result = workService.getAll();
		WriteLog(result);
	}

	@Test
	public void get() {
		int workNumber = 1;
		var result = workService.get(workNumber);
		WriteLog(result);
	}
}
