package unit.org.craftedsw.tww.controller.trips;

import static org.craftedsw.tww.view.View.REDIRECT_TO_ALL_TRIPS_PAGE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.craftedsw.tww.controller.TripsController;
import org.craftedsw.tww.model.trip.Trip;
import org.craftedsw.tww.model.trip.TripBO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;


@RunWith(MockitoJUnitRunner.class)
public class TripControllerTest {

	private static final BindingResult UNUSED_BINDING_RESULT = null;
	private TripsController tripsController;

	@Mock private TripBO tripBO;

	@Before
	public void initialise() {
		tripsController = new TripsController();
		tripsController.setTripBO(tripBO);
	}
	
	@Test public void
	should_add_a_trip() {
		Trip trip = new Trip();
		
		tripsController.addTrip(trip, UNUSED_BINDING_RESULT);
		
		verify(tripBO).create(trip);
	}
	
	@Test public void
	should_navigate_to_all_trips_page_after_adding_a_trip() {
		String navigation = tripsController.addTrip(new Trip(), UNUSED_BINDING_RESULT);
		
		assertThat(navigation, is(equalTo(REDIRECT_TO_ALL_TRIPS_PAGE)));
	}
	
}
