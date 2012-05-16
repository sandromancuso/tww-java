package system.org.craftedsw.tww.trips;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class TripSteps {

	private WebDriver driver;
	private String pageTitle;
	private AddTripPage addTripPage;
	private AllTripsPage allTripsPage;
	
	@Before
	public void initialise() {
//		driver = new FirefoxDriver();
		driver = new HtmlUnitDriver();
	}

	@Given("^I am on the front page$")
	public void I_am_on_the_front_page() {
		driver.get("http://localhost:8080/alltrips");
	}

	@When("^I decide to see all existing trips$")
	public void I_decide_to_see_all_existing_trips() {
		pageTitle = driver.getTitle();
	}

	@Then("^I should see a list of all trips$")
	public void I_should_see_a_list_of_all_trips() {
		assertThat(pageTitle, is("The WorldWalkers - All Trips"));
	}
	
	@Given("^I am on the all trips page$")
	public void I_am_on_the_all_trips_page() {
		driver.get("http://localhost:8080/alltrips/anotherpage");
	}

	@When("^I decide to see another page$")
	public void I_decide_to_see_another_page() {
		pageTitle = driver.getTitle();
	}

	@Then("^I should see another page$")
	public void I_should_see_another_page() {
		assertThat(pageTitle, is("Another page"));
	}	
	
	@Given("^I populate all my trip details$")
	public void I_populate_all_my_trip_details() {
		addTripPage = new AddTripPage(driver);
		addTripPage.visit();
		addTripPage.fillInTripNameWith("Northern Italy");
		addTripPage.fillInTripDescriptionWith("Great familily holidays");
	}

	@When("^I save it$")
	public void I_save_it() {
		allTripsPage = addTripPage.save();
	}

	@Then("^I should see it displayed$")
	public void I_should_see_it_displayed() {
		assertThat(allTripsPage.containsTripWithName("Northern Italy"), is(true));
		assertThat(allTripsPage.containsTripWithDescription("Great familily holidays"), is(true));
	}
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	
}
