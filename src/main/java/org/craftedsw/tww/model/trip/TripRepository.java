package org.craftedsw.tww.model.trip;

import java.util.List;

public interface TripRepository {

	Trip create(Trip trip);

	List<Trip> findAllTrips();

}
