package com.example.demo.common.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	// annotation 사용한 method일때 로그 출력.
	@Around("@annotation(RunningLog)") // method 실행 되는 전 과정
	public Object RunningLog(ProceedingJoinPoint joinPoint) throws Throwable {
		Date date = new Date();
		System.out.println("start => " + date.getTime());
		date.getTime(); // 메소드가 실행되는 현재 시간

		Object ret = joinPoint.proceed();

		System.out.println("end => " + date.getTime());

		return ret;
	}

}
