package org.craftedsw.tww.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.craftedsw.tww.model.trip.Trip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alltrips")
public class AllTripsController {
	
	@RequestMapping(method = GET)
	public String displayAllTrips(Map<String, Object> map) {
		System.out.println("All trips");
		Trip trip = new Trip("Test trip");
		trip.setId(1);
		List<Trip> tripList = new ArrayList<Trip>();
		tripList.add(trip);
		map.put("tripList", tripList);
		return "alltrips";
	}
	
	@RequestMapping(value="/anotherpage") 
	public String anotherPage() {
		System.out.println("Another page");
		return "anotherpage";
	}

}
