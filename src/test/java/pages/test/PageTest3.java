package pages.test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PageTest3 extends BaseTest {

	WebDriver driver;

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	@Parameters({"browserName"})
	@BeforeMethod
	public void beforeMethod(String browserName) throws MalformedURLException {
		driver = new ChromeDriver() ; //DriverFactory.getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.coverfox.com/");

	}

	// @AfterTest
	// public void afterTest() {
	// Reporter.log("afterTest",true);
	// }
	//
	// @BeforeTest
	// public void beforeTest() {
	// Reporter.log("beforeTest",true);
	// }

	@Test(groups = "smoke" , testName = "test1", description = "PageTest3 test1 description" , timeOut = 3000 )
	public void test1() throws FileNotFoundException {
		Assert.assertTrue(true);
	}

	@Test(groups = {"regression","sanity"} , testName = "test3", description = "PageTest3 test3 description" , timeOut = 3000 )
	public void test3() throws FileNotFoundException {
		Assert.assertTrue(true);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest3 test4 description" , timeOut = 3000 )
	public void test4() {
		Assert.assertTrue(true);
	}
	@Test(groups = "regression" , testName = "test2", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test2() {
		Assert.assertTrue(true);
	}
	
	@Test(groups = "sanity" , testName = "test5", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test5() {
		Assert.assertTrue(true);
	}
	@Test(groups = "smoke" , testName = "test6", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test6() {
		Assert.assertTrue(true);
	}
	@Test(groups = "sanity" , testName = "test7", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test7() {
		Assert.assertTrue(true);
	}
	@Test(groups = "end-to-end" , testName = "test8", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test8() {
		Assert.assertTrue(true);
	}
	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
	

}
