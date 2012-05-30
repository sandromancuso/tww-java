package unit.org.craftedsw.tww.infrastructure.repositories;

import static org.craftedsw.tww.matchers.BeanHas.has;
import static org.craftedsw.tww.matchers.BeanProperty.property;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.craftedsw.tww.infrastructure.JpaTripRepository;
import org.craftedsw.tww.model.trip.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@ActiveProfiles("default")
public class JpaTripRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JpaTripRepository tripRepository;
	
	@Test public void
	should_create_a_new_trip() {
		Trip trip = new Trip();
		trip.setName("Italy");
		trip.setDescription("Family holidays");
		
		Trip createdTrip = tripRepository.create(trip);
		
		assertThat(createdTrip, has(
									property("id", equalTo(1)),
									property("name", equalTo("Italy")),
									property("description", equalTo("Family holidays"))));
	}
	
}
