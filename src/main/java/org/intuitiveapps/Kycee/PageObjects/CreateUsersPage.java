package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage  extends AbstractComponents {
	WebDriver driver;
	public CreateUsersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name  ="firstName") WebElement firstNameInput;
	@FindBy(name ="lastName") WebElement lastNameInput;
	@FindBy(name = "email") WebElement emailIDInput;
	@FindBy(name = "phoneNumber") WebElement phoneNumberInput;
	@FindBy(css = "#react-select-2-placeholder") WebElement userTypeDrop;
	@FindBy(css = "#react-select-2-option-0") WebElement adminTypeOption;
	@FindBy(css = "#react-select-2-option-1") WebElement userTypeOption;
	@FindBy(name = "verification") WebElement allotVerificationInput;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitBtn;
	@FindBy(css="[class*='Toastify__toast-body']") WebElement ToastMsg;
	
	public void createUsers(String firstName,String lastName,String emailID,String phoneNumber,String userType,String verificationCount) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailIDInput.sendKeys(emailID);
		phoneNumberInput.sendKeys(phoneNumber);
		userTypeDrop.click();
		if(userType.equalsIgnoreCase("Admin")) {
			adminTypeOption.click();
		}else if (userType.equalsIgnoreCase("User")) {
			userTypeOption.click();
		}
		allotVerificationInput.sendKeys(verificationCount);
		submitBtn.click();
	}
}