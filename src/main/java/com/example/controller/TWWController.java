package com.example.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tww")
public class TWWController {
	
	@RequestMapping(value = "/", method = GET)
	public void displayHomePage() {
		System.out.println("Home page");
	}
	
	@RequestMapping(value="/anotherpage", method = GET)
	public void anotherPage() {
		System.out.println("Another page");
	}

}
