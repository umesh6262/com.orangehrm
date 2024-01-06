package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_004_SuzukiTest extends BaseTest {

	@Test(groups = "smoke" , description = "PageTest2 test1 description" )
	public void TC_001_Suzuki_Test() {
		GooglePage gp = new GooglePage(driver);
		gp.enterTextInSearchBox("Suzuki Access 125");
		gp.selectOptionFromSuggestionList();
		Assert.assertTrue(true);
	}

}
