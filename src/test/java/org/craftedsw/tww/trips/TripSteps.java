package org.craftedsw.tww.trips;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import cucumber.table.DataTable;

public class TripSteps {

	private WebDriver driver;
	private String pageTitle;
	
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
		assertThat(pageTitle, is("Another page2"));
	}	
	
	@Given("^the Trips:$")
	public void the_Trips(DataTable tripTable) {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}

	@When("^I want to see all the trips on The WorldWalkers$")
	public void I_want_to_see_all_the_trips_on_The_WorldWalkers() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should see a list containing all of them$")
	public void I_should_see_a_list_containing_all_of_them() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}	
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	
}
