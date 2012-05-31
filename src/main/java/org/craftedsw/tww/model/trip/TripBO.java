package org.craftedsw.tww.model.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripBO {

	@Autowired
	private TripRepository tripRepository;

	public Trip create(Trip trip) {
		return tripRepository.create(trip);
	}

	public void set(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}

	public List<Trip> getAllTrips() {
		return tripRepository.findAllTrips();
	}

}
