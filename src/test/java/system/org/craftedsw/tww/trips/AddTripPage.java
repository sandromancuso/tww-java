package system.org.craftedsw.tww.trips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTripPage {

	private static final String PAGE_URL = "http://localhost:8080/trips/add";
	private WebDriver driver;

	public AddTripPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit() {
		driver.get(PAGE_URL);
	}

	public void fillInTripNameWith(String tripName) {
		driver.findElement(By.id("txtName")).sendKeys(tripName);
	}

	public void fillInTripDescriptionWith(String tripDescription) {
		driver.findElement(By.id("txtDescription")).sendKeys(tripDescription);
	}

	public AllTripsPage save() {
		driver.findElement(By.id("btnSaveTrip")).submit();
		return new AllTripsPage(driver);
	}

}
