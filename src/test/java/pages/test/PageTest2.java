package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTest2 extends BaseTest {

	@Test(groups = "smoke" , testName = "test1", description = "PageTest2 test1 description" , timeOut = 3000 )
	public void test1() {
		System.out.println("test1 started sysout");
		addAuthor("Umesh Shelke");
		addLog("adding logs to test1");
		Assert.assertTrue(true);
	}

	@Test(groups = "regression" , testName = "test3", description = "PageTest2 test3 description" , timeOut = 3000 )
	public void test3() {
		System.out.println("test3 started sysout");
		addAuthor("Shyam Shelke");
		Assert.assertTrue(false);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest2 test4 description"  )
	public void test4() {
		addAuthor("Tom");
		driver.navigate().forward();
		
	}

}
