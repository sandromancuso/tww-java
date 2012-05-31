package org.craftedsw.tww.infrastructure;

import static org.craftedsw.tww.model.trip.Trip.ALL_TRIPS_QUERY;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.craftedsw.tww.model.trip.Trip;
import org.craftedsw.tww.model.trip.TripRepository;
import org.springframework.stereotype.Repository;

@Repository(value="tripRepository")
public class JpaTripRepository implements TripRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Trip create(Trip trip) {
		em.persist(trip);
		return trip;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> findAllTrips() {
		return em.createNamedQuery(ALL_TRIPS_QUERY).getResultList();
	}

}
