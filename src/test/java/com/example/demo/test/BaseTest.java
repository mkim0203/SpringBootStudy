package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
public class BaseTest {

	public void writeLog(String message) {
		log.trace("테스트 코드 로그 출력 ==>");
		log.trace(message);
	}

	public void writeDebug(Object obj) {
		log.debug(obj.toString());
	}
	
	public void writeLog(Object obj) {
		log.trace("테스트 코드 로그 출력 (object) ==>");
		log.trace(obj.toString());
	}

	public void writeWebClientResponseException(WebClientResponseException webEx) {
		writeDebug(webEx.getStatusCode());
		writeDebug(webEx.getResponseBodyAsString());

	}

	public void writeWebClientRequestException(WebClientRequestException webEx) {
		log.error(webEx.getMessage());

	}
}
