package com.spring.jdbc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class LoginController {

	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println("ok 001");
        System.out.println("ok 002");
		return "springboot app a";
	}
}
