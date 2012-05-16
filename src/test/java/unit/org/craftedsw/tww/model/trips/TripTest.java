package unit.org.craftedsw.tww.model.trips;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.craftedsw.tww.model.trip.Trip;
import org.junit.Before;
import org.junit.Test;

public class TripTest {
	
	private Trip trip;

	@Before
	public void initialise() {
		trip = new Trip("NO NAME");
	}
	
	@Test public void
	should_have_a_name_when_created() {
		Trip trip = new Trip("Europe");
		
		assertThat(trip.getName(), is("Europe"));
	}
	
	@Test public void
	should_allow_name_to_be_changed() {
		trip.setName("Family holidays");
		
		assertThat(trip.getName(), is("Family holidays"));
	}
	
	@Test public void
	should_have_a_changable_description() {
		trip.setDescription("Some description");
		
		assertThat(trip.getDescription(), is("Some description"));
	}
	
	@Test public void
	should_have_a_changeable_id() {
		trip.setId(1);
		
		assertThat(trip.getId(), is(1));
	}
	
}
