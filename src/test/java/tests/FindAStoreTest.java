package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import config.propertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FindAStorePage;

public class FindAStoreTest {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentRep;
	public ExtentTest extentTest;
	WebDriver driver = null;
	public static String browserName=null;




	@Parameters({"browserName"})
	@BeforeTest
	public void setDriver(String browserName)
	{
		sparkReporter = new ExtentSparkReporter("./reports/ExtentReport.html");
		sparkReporter.config().setEncoding("UTF-8");
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("Automation Tests Results");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extentRep = new ExtentReports();
		extentRep.setSystemInfo("Orgnization", "Lets learn it");
		extentRep.setSystemInfo("browserName", "Chrome");	
		extentRep.attachReporter(sparkReporter);



		//browserName=propertiesFile.getProperties();
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

	@Test
	public void searchStore() throws InterruptedException
	{
		driver.get("https://www.bridgestonetire.com/ ");
		extentTest = extentRep.createTest("Search store with valid data");
		//extentTest.log(Status.PASS, "Page loaded successfully");
		FindAStorePage fas = new FindAStorePage(driver);
		fas.clickFindAStoreBTN();
		fas.clickMyStoreLink();
		fas.setStore("newyork");
		fas.clickSearchBTN();
	}

	@Test
	public void searchStoreFail() throws InterruptedException
	{
		driver.get("https://www.bridgestonetire.com/ ");
		extentTest = extentRep.createTest("Store Search with invalid data");
		//extentTest.log(Status.FAIL, "Page loaded unsuccessfully");
		FindAStorePage fas = new FindAStorePage(driver);
		fas.clickFindAStoreBTN();
		fas.clickMyStoreLink();
		fas.setStore("abc");
		fas.clickSearchBTN();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		extentRep.flush();
	}
	
	@AfterMethod
	public void reportResults(ITestResult results)
	{
		if(results.getStatus()==ITestResult.FAILURE) {
		extentTest.log(Status.FAIL, "Test case faied  "+results.getName());
		extentTest.log(Status.FAIL, "Test case faied  "+results.getThrowable());
		
		
		
		}else if (results.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case passed  "+results.getName());
		}
}
		
}