package pages.test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import manager.TestManager;
import utility.Utility;

public abstract class BaseTest {

	protected WebDriver driver;
	private String driverSessionId = null;

	@BeforeMethod()
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("before method");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		// print the session id of the driver
		driverSessionId = ((RemoteWebDriver) driver).getSessionId().toString();
		System.out.println(driverSessionId);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get("https://www.coverfox.com/");

	}

	@AfterMethod(alwaysRun = true)
	public void AfterMethod() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Object getCurrentObject() {
		return this;
	}

	public void addLog(String logMessage) {
		TestManager.addLogToTest(getCurrentObject(), logMessage);
		Reporter.log(logMessage);
	}

	public void addAuthor(String author) {
		System.out
				.println("Adding Author BaseTest : " + getCurrentObject() + " Avtive Count : " + Thread.activeCount());
		TestManager.assignAuthorToTest(getCurrentObject(), author);
	}
}
