package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.propertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.dataProvider;

public class LoginTest {
	WebDriver driver = null;
    public static String browserName=null;
    
	@BeforeTest
	public void setDriver()
	{
		browserName=propertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
		
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	}
	
	
	@Test(dataProviderClass = utils.dataProvider.class,dataProvider="commonDataProvider")
	public void loginTest(String email,String password) throws InterruptedException {
		driver.get("https://cwh-uat.bridgestonetire.com/");
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.clickSignInLink();
		Thread.sleep(2000);
		lp.clickSignInLinkFlyout();
		Thread.sleep(2000);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickSignInBtn();
		Thread.sleep(2000);
	   lp.clickMyProfileLink();
	   Thread.sleep(2000);
	   lp.clickSignOutLink();
	}


}
