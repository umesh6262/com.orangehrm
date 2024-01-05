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

	@Test(groups = "smoke" , testName = "test1", description = "PageTest2 test1 description" , timeOut = 3000 )
	public void test1() throws FileNotFoundException, InterruptedException {
		System.out.println("test1 started sysout");
		addAuthor("Umesh Shelke");
		addLog("adding logs to test1");
		Assert.assertTrue(true);
	}

	@Test(groups = "regression" , testName = "test3", description = "PageTest2 test3 description" , timeOut = 3000 )
	public void test3() throws FileNotFoundException, InterruptedException {
		System.out.println("test3 started sysout");
		Thread.sleep(1000);
		addAuthor("Shyam Shelke");
		Assert.assertTrue(false);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest2 test4 description"  )
	public void test4() throws InterruptedException {
		addAuthor("Tom");
		driver.navigate().forward();
		Thread.sleep(1000);
	}

}
