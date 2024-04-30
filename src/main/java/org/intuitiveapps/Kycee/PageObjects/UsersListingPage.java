package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersListingPage  extends AbstractComponents {
	WebDriver driver;
	public UsersListingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className  ="add-user") WebElement addUserBtn;
	@FindBy(name ="lastName") WebElement lastNameInput;
	@FindBy(name = "email") WebElement emailIDInput;
	@FindBy(name = "phoneNumber") WebElement phoneNumberInput;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitBtn;
	@FindBy(css="[class*='Toastify__toast-body']") WebElement ToastMsg;
	
	public void clickOnAddUsersButton() {
		addUserBtn.click();
	}

}
