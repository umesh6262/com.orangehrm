package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetailsPage {
	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pincodeField;

	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement mobileNumberField;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continueButton;

	public AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPincode(String pincode) {
		pincodeField.sendKeys(pincode);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
}
