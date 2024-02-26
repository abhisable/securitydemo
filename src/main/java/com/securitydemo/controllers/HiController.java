package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@GetMapping("/hi")
	public String sayHi(){
		return "hi";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}
