package com.example.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alltrips")
public class AllTripsController {
	
	@RequestMapping(method = GET)
	public String displayAllTrips() {
		System.out.println("All trips");
		return "alltrips";
	}
	
	@RequestMapping(value="/anotherpage") 
	public String anotherPage() {
		System.out.println("Another page");
		return "anotherpage";
	}

}
