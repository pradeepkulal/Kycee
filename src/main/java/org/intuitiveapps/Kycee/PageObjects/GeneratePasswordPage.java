package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratePasswordPage extends AbstractComponents{
	WebDriver driver;
	public GeneratePasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath  ="//input[@name='password']") private WebElement passwordInput;
	@FindBy(xpath ="//input[@name='confirmPassword']") WebElement confirmPasswordInput;
	@FindBy(className = "icon-group-end") private WebElement toggleEyeIcon;
	
	@FindBy(xpath = "//input[@type='submit']") WebElement submitBtn;

	public void fillPassword(String password, String confirmPassword) {
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(confirmPassword);
		toggleEyeIcon.click();
		submitBtn.click();
	}
}
