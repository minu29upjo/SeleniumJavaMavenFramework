package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAStorePage {
	
WebDriver driver = null;


By FindAStoreBTN= By.xpath("//button[@title='Find A Store']");
By MyStoreLink=By.xpath("//a[contains(@class,'commerceFlyoutFindMyStore')]");
By SearchInput=By.id("storelocator-query");
By SearchBTN=By.xpath("//button[@class='btn btn-primary']");


public FindAStorePage(WebDriver driver)
{
	this.driver=driver;
}


public void clickFindAStoreBTN()
{
	driver.findElement(FindAStoreBTN).click();
}

public void clickMyStoreLink()
{
	driver.findElement(MyStoreLink).click();
}

public void setStore(String store)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(SearchInput))).sendKeys(store);
	}

public void clickSearchBTN()
{
	driver.findElement(SearchBTN).click();
}
}
