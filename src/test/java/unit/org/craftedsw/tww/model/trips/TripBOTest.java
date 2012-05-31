package unit.org.craftedsw.tww.model.trips;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tww.model.trip.Trip;
import org.craftedsw.tww.model.trip.TripBO;
import org.craftedsw.tww.model.trip.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TripBOTest {
	
	private TripBO tripBO;
	
	@Mock private TripRepository tripRepository;
	
	private Trip createdTrip = new Trip();

	@Before 
	public void initialise() {
		tripBO = new TripBO();
		tripBO.set(tripRepository);
	}
	
	@Test public void
	should_create_a_new_trip() {
		when(tripRepository.create(any(Trip.class))).thenReturn(createdTrip);
		
		Trip resultTrip = tripBO.create(new Trip("Holidays in UK"));
		
		assertThat(resultTrip, is(createdTrip));
	}
	
	@Test public void
	should_return_a_list_of_all_trips() {
		List<Trip> tripList = new ArrayList<Trip>();
		when(tripRepository.findAllTrips()).thenReturn(tripList);
		
		List<Trip> allTrips = tripBO.getAllTrips();
		
		assertThat(allTrips, is(equalTo(tripList)));
	}

}
