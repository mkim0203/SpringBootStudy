package com.example.demo.common.aop;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.jwt.JwtManager;
import com.example.demo.common.model.RequestLogModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ControllerAspect {
	// controller 수행시 로그 출력.
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	public void controllerPointcut() {

	}

	@Around("controllerPointcut()")
	public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("api 수행 위치 및 url 정보 aop");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		controllerLog(joinPoint, request);
		controllerJwtCheck(joinPoint);

		Object result = joinPoint.proceed();
		return result;
	}

	private void controllerLog(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
		String controllerName = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		String requestUrl = request.getRequestURI();
		String requestMethodType = request.getMethod();

		RequestLogModel logModel = new RequestLogModel(controllerName, methodName, requestUrl, requestMethodType);

		log.info(logModel.toString());
	}

	/**
	 * 클레스용 jwt 인증 체크.. 클래스 annotation 인경우 Pointcut을 사용해서 해야함.. ...이유는 찾아봐야함 -_-
	 * @throws Throwable 
	 */
	private void controllerJwtCheck(ProceedingJoinPoint joinPoint) {
		System.out.println("jwt 인증 체크 aop");
		var controller = joinPoint.getSignature().getDeclaringType();
//		System.out.println(controller.getName());

		Annotation tokenAnnotation = controller.getAnnotation(NeedToken.class);

		if (tokenAnnotation != null) {
			System.out.println(tokenAnnotation);
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			String token = request.getHeader("jwt-token");
			log.info("token => " + token);

			if (StringUtils.isEmpty(token)) {
				System.out.println("token null or empty");
				throw new JwtException();
			} else {
				JwtManager jwtManager = new JwtManager();
				jwtManager.checkJwtToken(token);
			}
			log.info("jwt 인증 체크 OK");
		} else {
			log.info("jwt 인증 체크 PASS");
		}
	}

//	@Around("controllerLog()")
//	public Object checkJwtAuth(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("jwt 인증 체크 aop");
//
//		var controller = joinPoint.getSignature().getDeclaringType();
//		System.out.println(controller.getName());
//
//		Annotation tokenAnnotation = controller.getAnnotation(NeedTokenInController.class);
//
//		if (tokenAnnotation != null) {
//			System.out.println(tokenAnnotation);
//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//					.getRequest();
//
//			String token = request.getHeader("jwt-token");
//			System.out.println("token => " + token);
//
//			if (StringUtils.isEmpty(token)) {
//				System.out.println("token null or empty");
//				throw new JwtException();
//			} else {
//				Object ret = joinPoint.proceed();
//
//				return ret;
//			}
//		} else {
//			Object ret = joinPoint.proceed();
//
//			return ret;
//		}
//	}
}
