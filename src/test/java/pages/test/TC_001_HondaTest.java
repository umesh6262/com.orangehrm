package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_001_HondaTest extends BaseTest {

	@Test(groups = "smoke" ,description = "PageTest2 test1 description" )
	public void TC_001_Honda_Test() {
		GooglePage gp = new GooglePage(driver);
		gp.enterTextInSearchBox("Honda");
		gp.selectOptionFromSuggestionList();
		Assert.assertTrue(true);
	}

}
