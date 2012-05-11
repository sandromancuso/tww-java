package com.example.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/alltrips/anotherpage")
public class AnotherController {
	
//	@RequestMapping(value="/anotherpage") 
//	@RequestMapping(method=GET) 
	public void anotherPage() {
		System.out.println("Another page");
//		return "anotherpage";
	}

}
