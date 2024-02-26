package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

	@GetMapping("/bye")
	public String sayBye(){
		return "bye everyone";
	}
	
}
