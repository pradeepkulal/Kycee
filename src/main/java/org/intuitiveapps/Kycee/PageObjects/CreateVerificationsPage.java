package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVerificationsPage extends AbstractComponents {
	WebDriver driver;
	public CreateVerificationsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name  ="firstName") WebElement firstNameInput;
	@FindBy(name ="lastName") WebElement lastNameInput;
	@FindBy(xpath = "//input[@type='email']") WebElement emailIDInput;
	@FindBy(xpath = "//input[@type='number']") WebElement phoneNumberInput;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitBtn;
	@FindBy(css="[class*='Toastify__toast-body']") WebElement ToastMsg;
	
	public void createVerifications(String firstName,String lastName,String emailID,String phoneNumber) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailIDInput.sendKeys(emailID);
		phoneNumberInput.sendKeys(phoneNumber);
		submitBtn.click();
	}
}
