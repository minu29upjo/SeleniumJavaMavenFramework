package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	WebDriver driver = null;

public BasePage(WebDriver driver) {
		this.driver=driver;
	}
}
