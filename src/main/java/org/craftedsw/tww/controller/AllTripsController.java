package org.craftedsw.tww.controller;

import static org.craftedsw.tww.view.View.ALL_TRIPS_PAGE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;

import org.craftedsw.tww.model.trip.TripBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alltrips")
public class AllTripsController {
	
	public static final String TRIP_LIST_KEY = "tripList";
	
	@Autowired
	private TripBO tripBO;

	@RequestMapping(method = GET)
	public String displayAllTrips(Map<String, Object> map) {
		map.put(TRIP_LIST_KEY, tripBO.getAllTrips());
		return ALL_TRIPS_PAGE;
	}
	
	@RequestMapping(value="/anotherpage") 
	public String anotherPage() {
		System.out.println("Another page");
		return "anotherpage";
	}

	public void setTripBO(TripBO tripBO) {
		this.tripBO = tripBO;
	}

}
