package system.org.craftedsw.tww.trips;

import java.util.List;

import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllTripsPage {

	private WebDriver driver;

	public AllTripsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean containsTripWithName(String name) {
		return containsTripRowWith(name);
	}

	public boolean containsTripWithDescription(String description) {
		return containsTripRowWith(description);
	}

	private boolean containsTripRowWith(String name) {
		List<WebElement> tripNames = driver.findElements(ByTagName.className("tripRow"));
		for (WebElement tripName : tripNames) {
			if (name.equals(tripName.getText())) {
				return true;
			}
		}
		return false;
	}
	
}
