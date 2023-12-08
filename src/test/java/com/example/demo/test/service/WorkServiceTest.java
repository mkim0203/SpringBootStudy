package com.example.demo.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Work;
import com.example.demo.service.IWorkService;
import com.example.demo.service.WorkService;
import com.example.demo.test.BaseTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WorkServiceTest extends BaseTest {

	@Autowired
	IWorkService workService;

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

	@Test
	public void getList() {
		String workNameLike = "work";
		var result = workService.getList(workNameLike);
		WriteLog(result);
	}

	/**
	 * Test 코드 트렌젝션은 자동롤백됨.
	 */
	@Test
	@Transactional
	public void insert() {
		Work data = new Work();
		data.setWorkName("test");
		data.setWorkNumber(2);
		try {
			workService.insert(data);
		} catch (Exception e) {
			WriteLog(e);
		}
	}


	@Test
	public void update() {
		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			workService.update(null);
		});

		WriteLog(exception);
	}

	@Test
	public void test() {
		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			workService.test(null);
		});
	}
}
