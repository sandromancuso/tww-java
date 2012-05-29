package unit.org.craftedsw.tww.model.trips;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static unit.org.craftedsw.tww.model.trips.TripTest.BeanMatcher.has;
import static unit.org.craftedsw.tww.model.trips.TripTest.PropertyWithValueMatcher.property;

import org.craftedsw.tww.model.trip.Trip;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.StringDescription;
import org.hamcrest.beans.HasPropertyWithValue;
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
	
	@Test public void
	should_have_mutable_properties() {
		trip.setId(1);
		trip.setName("Verona");
		trip.setDescription("Family holidays");
	
		MatcherAssert.assertThat(trip, has(
										property("id", equalTo(1)),
										property("name", equalTo("Verona")),
										property("description", equalTo("Family holidays"))));
	}
	
	public static class BeanMatcher<T> extends BaseMatcher<T> {
		
		private Matcher<?>[] propertyMatchers;
		private Description expectedDescription = new StringDescription();
		private Description mismatchDescription = new StringDescription();

		public BeanMatcher(Matcher<?>... propertyMatchers) {
			this.propertyMatchers = propertyMatchers;
		}

		@Factory
		public static <T> BeanMatcher<T> has(Matcher<?>... propertyMatchers) {
			return new BeanMatcher<T>(propertyMatchers);
		}
		
		@Override
		public boolean matches(Object item) {
			boolean matches = true;
			for (Matcher<?> matcher : propertyMatchers) {
				if (!matcher.matches(item)) {
					matches = false;
					appendDescriptions(item, matcher);
				}
			}
			return matches;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText(expectedDescription.toString());
		}

		@Override
		public void describeMismatch(Object item, Description description) {
			description.appendText(mismatchDescription.toString());
		}

		private void appendDescriptions(Object item, Matcher<?> matcher) {
			matcher.describeTo(expectedDescription);
			matcher.describeMismatch(item, mismatchDescription);
			mismatchDescription.appendText(" ");
		}
		
	}
	
	public static class PropertyWithValueMatcher<T> extends HasPropertyWithValue<T> {

		private String propertyName;
		private Matcher<?> valueMatcher;
		
		public PropertyWithValueMatcher(String propertyName, Matcher<?> valueMatcher) {
			super(propertyName, valueMatcher);
			this.propertyName = propertyName;
			this.valueMatcher = valueMatcher;
		}

		@Factory
		public static <T> Matcher<T> property(String propertyName, Matcher<?> value) {
			return new PropertyWithValueMatcher<T>(propertyName, value);
		}
		
		@Override
		public void describeTo(Description description) {
			 description.appendText("property ");
		     description.appendValue(propertyName);
		     description.appendText(" = ");
		     description.appendDescriptionOf(valueMatcher);
		     description.appendText(" ");
		}

	}
	
}
