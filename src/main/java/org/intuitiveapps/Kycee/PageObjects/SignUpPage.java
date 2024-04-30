package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractComponents {
	WebDriver driver;
	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name  ="firstName") WebElement firstNameInput;
	@FindBy(name ="lastName") WebElement lastNameInput;
	@FindBy(name = "email") WebElement emailIDInput;
	@FindBy(name = "phoneNumber") WebElement phoneNumberInput;
	@FindBy(name = "password") WebElement passwordInput;
	@FindBy(xpath = "//input[@value='yes']") WebElement yesCheckBox;
	@FindBy(xpath = "//input[@value='no']") WebElement noCheckBox;
	@FindBy(name = "confirmPassword") WebElement confirmPasswordInput;
	@FindBy(name = "companyName") WebElement companyNameInput;
	@FindBy(name = "cinNumber") WebElement cinNumberInput;
	@FindBy(name = "gstin") WebElement gstinInput;
	@FindBy(xpath = "//input[@value='Submit']") WebElement submitBtn;
	@FindBy(partialLinkText  = "/login") WebElement loginPageBtn;
	@FindBy(css="[class*='Toastify__toast-body']") WebElement ToastMsg;
	
	public void fillTheForm(String firstName,String lastName,String emailID,String phoneNumber,String password,
			String confirmPassword,String companyName,String cinNumber,String gstin) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailIDInput.sendKeys(emailID);
		phoneNumberInput.sendKeys(phoneNumber);
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(confirmPassword);
		yesCheckBox.click();
		companyNameInput.sendKeys(companyName);
		cinNumberInput.sendKeys(cinNumber);
		gstinInput.sendKeys(gstin);
		submitBtn.click();
	}
	
}
