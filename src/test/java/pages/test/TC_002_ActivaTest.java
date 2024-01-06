package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_002_ActivaTest extends BaseTest {

	@Test(groups = "smoke" ,description = "PageTest2 test1 description" )
	public void TC_001_Activa_Test() {
		GooglePage gp = new GooglePage(driver);
		gp.enterTextInSearchBox("Activa");
		gp.selectOptionFromSuggestionList();
//		Assert.assertTrue(false);
		gp.clickOnLink();
	}

}
