package com.example.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alltrips")
public class AllTripsController {
	
	@RequestMapping(method = GET)
	public void displayAllTrips() {
		System.out.println("All trips");
	}
	
	@RequestMapping(value="/anotherpage", method = GET)
	public void anotherPage() {
		System.out.println("Another page");
	}

}
