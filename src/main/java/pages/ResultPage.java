package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ResultPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'Health Insurance Plans')]")
	private WebElement resultHeading;
	
	@FindBy(id = "plans-list")
	private List<WebElement> plansList;
	
	@FindBy(xpath = "//div[text()='Preferred brands']")
	private WebElement preferredBrandsFilter;
	
	@FindBy(xpath = "//span[text()='Star Health Insurance']")
	private WebElement starHealthInsuranceOptionInPreferredBrandFilter;
	
	@FindBy(className = "apply-btn")
	private WebElement applyButtonInFilterPopup;

	@FindBy(xpath = "//div[@id='plans-list']//img[@alt='Star Health Insurance']")
	private List<WebElement> planListAfterSelectingStartHealthInsuranceOptionInPreferredBrandFilter;
	
	public ResultPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyNumberOfShownPlanCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(resultHeading));
		wait.until(ExpectedConditions.visibilityOfAllElements(plansList));
		
		int expectedCountOfPlans = Integer.parseInt(resultHeading.getText().split(" ")[0]);
		int actualCountOfShownPlans = plansList.size();
		if(expectedCountOfPlans == actualCountOfShownPlans) {
//			System.out.println("Number Of Plans Shown : "+actualCountOfShownPlans +" : TC is Passed");
			Reporter.log("Number Of Plans Shown : "+actualCountOfShownPlans +" : TC is Passed", true);
		}else {
//			System.out.println("Number Of Plans Shown : "+actualCountOfShownPlans +" Number Of Plan Expected :"+expectedCountOfPlans+": TC is Failed");
			Reporter.log("Number Of Plans Shown : "+actualCountOfShownPlans +" Number Of Plan Expected :"+expectedCountOfPlans+": TC is Failed", true);
		}
	}
	
	public void clickOnPreferredBrandFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(plansList));
		preferredBrandsFilter.click();
	}
	
	public void selectStarHealthInsuranceOptionInPreferredBrandFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(starHealthInsuranceOptionInPreferredBrandFilter));
		
		starHealthInsuranceOptionInPreferredBrandFilter.click();
	}
	public void clickOnApplyButtonInFilterPopup() {
		applyButtonInFilterPopup.click();
	}
	
	public void verifyPlanListContainsOnlyStartHealthInsurance() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElements(planListAfterSelectingStartHealthInsuranceOptionInPreferredBrandFilter));
		wait.until(ExpectedConditions.visibilityOf(resultHeading));
		
		int expectedCountOfPlans = Integer.parseInt(resultHeading.getText().split(" ")[0]);
		int actualCountOfShownPlans = plansList.size();
		if(expectedCountOfPlans == actualCountOfShownPlans) {
//			System.out.println("Number Of Plans Shown For StartHealthInsurance : "+actualCountOfShownPlans +" : TC is Passed");
			Reporter.log("Number Of Plans Shown For StartHealthInsurance : "+actualCountOfShownPlans +" : TC is Passed", true);
		}else {
//			System.out.println("Number Of Plans Shown For StartHealthInsurance : "+actualCountOfShownPlans +" Number Of Plan Expected :"+expectedCountOfPlans+": TC is Failed");
			Reporter.log("Number Of Plans Shown For StartHealthInsurance : "+actualCountOfShownPlans +" Number Of Plan Expected :"+expectedCountOfPlans+": TC is Failed", true);
		}
	}
}
