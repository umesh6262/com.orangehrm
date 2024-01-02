package pages.test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest2 extends BaseTest {

	WebDriver driver;

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		driver = new ChromeDriver() ; //DriverFactory.getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.coverfox.com/");

	}


	@Test(groups = "smoke" , testName = "test1", description = "PageTest2 test1 description" , timeOut = 3000 )
	public void test1() throws FileNotFoundException {
		Assert.assertTrue(true);
	}

	@Test(groups = "regression" , testName = "test3", description = "PageTest2 test3 description" , timeOut = 3000 )
	public void test3() throws FileNotFoundException {
		Assert.assertTrue(true);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest2 test4 description"  )
	public void test4() throws InterruptedException {
		driver.navigate().forward();
		Thread.sleep(1000);
		
		
	}
	
	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}
