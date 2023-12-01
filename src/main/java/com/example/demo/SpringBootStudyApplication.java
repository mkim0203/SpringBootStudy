package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.NeedJwtWorkController;

@SpringBootApplication
public class SpringBootStudyApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringBootStudyApplication.class);

	public static void main(String[] args) {
		logger.info("Start ~~!");
		SpringApplication.run(SpringBootStudyApplication.class, args);

	}

}
