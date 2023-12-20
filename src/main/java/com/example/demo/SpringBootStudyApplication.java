package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringBootStudyApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootStudyApplication.class);

	public static void main(String[] args) {
		logger.info("Start ~~!");
		SpringApplication.run(SpringBootStudyApplication.class, args);

	}

}
