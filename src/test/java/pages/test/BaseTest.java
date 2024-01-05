package pages.test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import manager.TestManager;


public abstract class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod()
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("before method");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get("https://www.coverfox.com/");

	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	public Object getCurrentObject() {
		return this;
	}
	public void addLog(String logMessage) {
		TestManager.addLogToTest(getCurrentObject() , logMessage);
		Reporter.log(logMessage);
	}
	public void addAuthor(String author) {
		System.out.println("Adding Author BaseTest : "+getCurrentObject() + " Avtive Count : "+Thread.activeCount() );
		TestManager.assignAuthorToTest(getCurrentObject(), author);
	}
}
