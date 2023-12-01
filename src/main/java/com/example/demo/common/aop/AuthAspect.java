package com.example.demo.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.common.jwt.JwtException;
import com.example.demo.common.jwt.JwtManager;

@Component
@Aspect
public class AuthAspect {

	@Autowired
	JwtManager jwtManager;
	/**
	 * 메서드용 jwt 인증 체크.
	 */
	@Around("@annotation(NeedToken)")
	public Object jwtTokenValid(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("start => jwtTokenValid ");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String token = request.getHeader("jwt-token");
		System.out.println("token => " + token);

		if (StringUtils.isEmpty(token)) {
			System.out.println("token null or empty");
			throw new JwtException();
		} else {
			System.out.println("token check");
			//JwtManager jwtManager = new JwtManager();
			// di 해줘야 함. 안하면 JwtManager 네부에서 사용하는 config 정보들 로드하지 못함.
			jwtManager.checkJwtToken(token);
		}

		Object ret = joinPoint.proceed();

		return ret;
	}

//	@Around("@annotation(NeedTokenInController)")
//	public Object jwtTokenValid2(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		System.out.println("start => jwtTokenValid2 ");
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//				.getRequest();
//
//		String token = request.getHeader("jwt-token");
//		System.out.println("token => " + token);
//
//		if (StringUtils.isEmpty(token)) {
//			System.out.println("token null or empty");
//			throw new JwtException();
//		} else {
//			Object ret = joinPoint.proceed();
//
//			return ret;
//		}
//	}

//	@Pointcut("execution(* com.example.demo.controller.NeedJwtWorkController.*(..))")
//	public void jwtAuthController() {
//		System.out.println("jwtAuthController");
//	}
//
//	@Pointcut("execution(* com.example.demo.controller.NeedJwtWork2Controller.*(..))")
//	public void jwtAuthController2() {
//		System.out.println("jwtAuthController2");
//	}

//	/**
//	 * 클레스용 jwt 인증 체크.. 클래스 annotation 인경우 Pointcut을 사용해서 해야함.. ...이유는 찾아봐야함 -_-
//	 */
//	@Around("jwtAuthController() || jwtAuthController2()")
//	public Object checkJwtAuth(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("checkJwtAuth");
//		
////		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
////		var classObj = signature.getClass();
////		System.out.println(classObj.getName());
//		
//		var controller = joinPoint.getSignature().getDeclaringType();
//		System.out.println(controller.getName());
//		
////		var annons = controller.getAnnotations();
////		for( Annotation annon : annons) {
////			System.out.println(annon);
////			
////		}
//		
//		Annotation tokenAnnotation =  controller.getAnnotation(NeedTokenInController.class);
//		
//		//Method method = signature.getMethod();
//		//NeedTokenInController tokenAnnotation = method.getAnnotation(NeedTokenInController.class);
//		
//		//System.out.println(tokenAnnotation);
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
