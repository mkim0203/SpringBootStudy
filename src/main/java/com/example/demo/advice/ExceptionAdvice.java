package com.example.demo.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.DataNotFoundException;
import com.example.demo.model.EmployeeNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	/*
	 * custom exception advidce 설정시 주의점.
	 * custom exception 상속을 java.lang.Exception 사용하면안됨.
	 * 아래 항목에 custom exception이 있어도 'serverError'를 타고 있음.
	 */

	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ResultModel<String> employeeNotFoundHandler(EmployeeNotFoundException ex) {
		System.out.println("employeeNotFoundHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode("NOT_FOUND");
		retValue.setData("employee not found 에러 => " + ex.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ResultModel<String> notFoundHandler(DataNotFoundException ex) {
		System.out.println("notFoundHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode("NOT_FOUND");
		retValue.setData(ex.getMessage());
		return retValue;

	}

	@ResponseBody
	@ExceptionHandler(JwtException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	ResultModel<String> jwtHandler(JwtException ex) {
		System.out.println("jwtHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode("FAIL_JWT_TOKEN");
		retValue.setData(ex.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ResultModel<String> runtimeHandler(JwtException ex) {
		System.out.println("runtimeHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode("RUNTIME_ERROR");
		retValue.setData(ex.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResultModel<String> serverError(Exception ex) {
		System.out.println("serverError");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode("FAIL");
		retValue.setData(ex.getMessage());
		return retValue;
	}
}

