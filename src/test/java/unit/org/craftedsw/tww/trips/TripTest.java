package unit.org.craftedsw.tww.trips;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.craftedsw.tww.trips.Trip;
import org.junit.Test;

public class TripTest {

	@Test public void
	shoudl_have_a_name() {
		Trip trip = new Trip("Europe");
		
		assertThat(trip.getName(), is("Europe"));
	}
	
}
