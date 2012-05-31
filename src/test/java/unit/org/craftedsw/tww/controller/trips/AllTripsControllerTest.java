package unit.org.craftedsw.tww.controller.trips;

import static org.craftedsw.tww.controller.AllTripsController.TRIP_LIST_KEY;
import static org.craftedsw.tww.view.View.ALL_TRIPS_PAGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.craftedsw.tww.controller.AllTripsController;
import org.craftedsw.tww.model.trip.Trip;
import org.craftedsw.tww.model.trip.TripBO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AllTripsControllerTest {
	
	private static final Map<String, Object> UNUSED_MODEL = new HashMap<String, Object>();
	private static final Map<String, Object> MODEL_MAP = new HashMap<String, Object>();
	private AllTripsController allTripsController;

	@Mock private TripBO tripBO;
	
	@Before
	public void initialise() {
		allTripsController = new AllTripsController();
		allTripsController.setTripBO(tripBO);
	}
	
	@Test public void
	should_navigate_to_all_trips_page() {
		String nextPage = allTripsController.displayAllTrips(UNUSED_MODEL);
		
		assertThat(nextPage, is(ALL_TRIPS_PAGE));
	}
	
	@SuppressWarnings("unchecked")
	@Test public void
	should_add_list_of_trips_to_model_map() {
		List<Trip> tripList = new ArrayList<Trip>();
		when(tripBO.getAllTrips()).thenReturn(tripList);
		
		allTripsController.displayAllTrips(MODEL_MAP);
		
		List<Trip> tripListReturnedByTheController = (List<Trip>)MODEL_MAP.get(TRIP_LIST_KEY);
		assertThat(tripListReturnedByTheController, is(tripList));
	}

}
