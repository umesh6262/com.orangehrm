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

	@Test(groups = "smoke" , testName = "test1", description = "PageTest3 test1 description" , timeOut = 3000 )
	public void test1() throws FileNotFoundException, InterruptedException {
		addAuthor("Lisa ");
		Assert.assertTrue(true);
	}

	@Test(groups = {"regression","sanity"} , testName = "test3", description = "PageTest3 test3 description" , timeOut = 3000 )
	public void test3() throws FileNotFoundException, InterruptedException {
		addAuthor("Jonathan");
		Assert.assertTrue(false);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest3 test4 description" , timeOut = 3000 )
	public void test4() {
		addAuthor("Umesh Shelke");
		Assert.assertTrue(true);
	}
	@Test(groups = "regression" , testName = "test2", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test2() {
		addAuthor("Jonathan");
		Assert.assertTrue(true);
	}
	
	@Test(groups = "sanity" , testName = "test5", description = "PageTest3 test2 description" , timeOut = 3000 )
	public void test5() {
		addAuthor("harry");
		Assert.assertTrue(true);
	}
	

}
