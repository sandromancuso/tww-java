package org.craftedsw.tww.trips;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class TripSteps {

	private WebDriver driver;
	private String pageTitle;
	
	@Before
	public void initialise() {
		driver = new FirefoxDriver();
	}

	@Given("^I am on the front page$")
	public void I_am_on_the_front_page() {
		driver.get("http://localhost:8080/alltrips/");
	}

	@When("^I decide to see all existing trips$")
	public void I_decide_to_see_all_existing_trips() {
		pageTitle = driver.getTitle();
	}

	@Then("^I should see a list of all trips$")
	public void I_should_see_a_list_of_all_trips() {
		assertThat(pageTitle, is("The WorldWalkers - All Trips"));
	}
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	
}
