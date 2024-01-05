package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTest3 extends BaseTest {

	@Test( groups = "smoke" , testName = "test1", description = "PageTest3 test1 description" )
	public void test1_PageTest3() {
		addAuthor("Lisa ");
		Assert.assertTrue(true);
	}

	@Test(groups = {"regression","sanity"} , testName = "test3", description = "PageTest3 test3 description" )
	public void test3_PageTest3() {
		addAuthor("Jonathan");
		Assert.assertTrue(false);
	}
	
	@Test(groups = "smoke" , testName = "test4", description = "PageTest3 test4 description"  )
	public void test4_PageTest3() {
		addAuthor("Umesh Shelke");
		Assert.assertTrue(true);
	}
	
	@Test(groups = "regression" , testName = "test2", description = "PageTest3 test2 description"  )
	public void test2_PageTest3() {
		addAuthor("Jonathan");
		Assert.assertTrue(true);
	}
	
	@Test(groups = "sanity" , testName = "test5", description = "PageTest3 test2 description"  )
	public void test5_PageTest3() {
		addAuthor("harry");
		Assert.assertTrue(true);
	}
	

}
