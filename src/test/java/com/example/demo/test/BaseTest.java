package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
public class BaseTest {

	public void WriteLog(String message) {
		log.trace("테스트 코드 로그 출력 ==>");
		log.trace(message);
	}

	public void WriteDebug(Object obj) {
		log.debug(obj.toString());
	}
	
	public void WriteLog(Object obj) {
		log.trace("테스트 코드 로그 출력 (object) ==>");
		log.trace(obj.toString());
	}

	public void WriteWebClientResponseException(WebClientResponseException webEx) {
		WriteDebug(webEx.getStatusCode());
		WriteDebug(webEx.getResponseBodyAsString());

	}
}
