package pages.test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public abstract class BaseTest {
	
	protected WebDriver driver;
	
	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Parameters({"browserName"})
	@BeforeMethod()
	public void beforeMethod(String browserName) throws MalformedURLException, InterruptedException {
		Thread.sleep(2000);
		driver = new ChromeDriver() ; //DriverFactory.getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get("https://www.coverfox.com/");

	}

	public WebDriver getWebDriver() {
		return driver;
	}
	public static void addLog(String logMessage) {
//		TestManager.addLogToTest(Thread.currentThread().threadId(), logMessage);
		Reporter.log(logMessage);
	}
}
