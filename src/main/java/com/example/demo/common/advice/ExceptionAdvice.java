package com.example.demo.common.advice;

import com.example.demo.common.model.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.demo.common.jwt.JwtAuthException;
import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.model.ResultModel;
import com.example.demo.model.DataNotFoundException;
import com.example.demo.model.EmployeeNotFoundException;

import javax.validation.ConstraintViolationException;

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
		retValue.setCode(ResultCode.NOT_FOUND);
//		retValue.setCode("NOT_FOUND");
		retValue.setData("employee not found 에러 => " + ex.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ResultModel<String> notFoundHandler(DataNotFoundException ex) {
		System.out.println("notFoundHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode(ResultCode.NOT_FOUND);
//		retValue.setCode("NOT_FOUND");
		retValue.setData(ex.getMessage());
		return retValue;

	}

	@ResponseBody
	@ExceptionHandler(JwtException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	ResultModel<String> jwtHandler(JwtException ex) {
		System.out.println("jwtHandler");
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode(ResultCode.FAIL_JWT_TOKEN);
//		retValue.setCode("FAIL_JWT_TOKEN");
		retValue.setData(ex.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ResultModel<String> runtimeHandler(RuntimeException ex) {
		System.out.println("runtimeHandler");
		System.out.println(ex.toString());
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode(ResultCode.RUNTIME_ERROR);
//		retValue.setCode("RUNTIME_ERROR");
		retValue.setData(ex.getMessage());
		return retValue;
	}
	
	@ResponseBody
	@ExceptionHandler(JwtAuthException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResultModel<String> jwtAuthHandler(JwtAuthException ex) {
		ResultModel<String> retValue = new ResultModel<String>();
		retValue.setCode(ResultCode.FAIL_JWT_AUTH);
//		retValue.setCode("FAIL_JWT_AUTH");
		retValue.setData(ex.getMessage());
		return retValue;
	}


	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResultModel<String> validError(ConstraintViolationException validEx) {
		System.out.println("validError");
		ResultModel<String> retValue = new ResultModel<>();
		retValue.setCode(ResultCode.FAIL_VALID);
		retValue.setData(validEx.getMessage());
		return retValue;
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResultModel<String> serverError(Exception ex) {
		System.out.println("serverError");
		ResultModel<String> retValue = new ResultModel<>();
		retValue.setCode(ResultCode.FAIL);
//		retValue.setCode("FAIL");
		retValue.setData(ex.getMessage());
		return retValue;
	}

}

