package com.test.begin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrller {

	@GetMapping("/test")
	public String test() {
		
		return "테스트입니다.";
	}
	
}
