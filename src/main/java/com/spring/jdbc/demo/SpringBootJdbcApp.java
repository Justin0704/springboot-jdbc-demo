package com.spring.jdbc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcApp {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcApp.class);
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootJdbcApp.class);
    }
}
