package com.example.controller;

import static org.craftedsw.tww.view.View.ADD_TRIP_PAGE;
import static org.craftedsw.tww.view.View.REDIRECT_TO_ALL_TRIPS_PAGE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Map;

import org.craftedsw.tww.model.trip.Trip;
import org.craftedsw.tww.model.trip.TripBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trips")
public class TripsController {
	
	@Autowired
	private TripBO tripBO;
	
	@RequestMapping(value = "/add", method = GET)
	public String displayAddTripPage(Map<String, Object> map) {
		map.put("trip", new Trip(""));
		return ADD_TRIP_PAGE;
	}
	
	@RequestMapping(value = "/add", method = POST)
	public String addTrip(@ModelAttribute("trip") Trip trip, BindingResult result) {
		tripBO.create(trip);
		
		return REDIRECT_TO_ALL_TRIPS_PAGE;
	}
	
	public void setTripBO(TripBO tripBO) {
		this.tripBO = tripBO;
	}

}
