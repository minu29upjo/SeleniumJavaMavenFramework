package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
WebDriver driver = null;

By SignInLink = By.xpath("//button[@title='Sign In']");
By SignInLinkFlyout = By.xpath("//li[contains(@class,'flyoutSignIn')]/span");
By EmailInputBox = By.id("commerceLoginFlyoutEmail");
By PasswordInputBox = By.xpath("//input[@type='password']");
By SignInBtn = By.xpath("//button[contains(@class,'LoginBTN')]");
By MyProfileLink=By.xpath("//div[text()='MY PROFILE']");
By SignOutLink=By.linkText("Sign Out");


public LoginPage(WebDriver driver) {
	this.driver=driver;
}

public void clickSignInLink() 
{
	driver.findElement(SignInLink).click();
}

public void clickSignInLinkFlyout() {
	driver.findElement(SignInLinkFlyout).click();
}
public void setEmail(String email) 
{
	driver.findElement(EmailInputBox).sendKeys(email);
}

public void setPassword(String password)
{
	driver.findElement(PasswordInputBox).sendKeys(password);
}

public void clickSignInBtn() 
{
	driver.findElement(SignInBtn).click();
}

public void clickMyProfileLink() 
{
	driver.findElement(MyProfileLink).click();
}
public void clickSignOutLink() 
{
	driver.findElement(SignOutLink).click();
}
}
