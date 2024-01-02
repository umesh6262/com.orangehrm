package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MemberDetailsPage {
	
	@FindBy(id ="Age-You")
	private WebElement selectAgeDropDown;
	
	@FindBy(className = "next-btn")
	private WebElement nextButton;
	
	public MemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SelectAgeFromDropDown(String age) {
		Select ageSelect = new Select(selectAgeDropDown);
		ageSelect.selectByValue(age);
	}
	
	public void clickOnNextButton() {
		nextButton.click();
	}
}
