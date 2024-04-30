package org.intuitiveapps.Kycee.PageObjects;

import javax.xml.xpath.XPath;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends AbstractComponents {
	WebDriver driver;
	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy (xpath = "//input[@name='password']") 
	private WebElement oldPasswordField;
	@FindBy (xpath = "//input[@name='newPassword']") 
	private WebElement newPasswordField;
	@FindBy (xpath = "//input[@name='confirmPassword']") 
	private WebElement confirmNewPasswordField;
	@FindBy (xpath = "//button[@type='submit']") 
	private WebElement submitBtn;
	@FindBy(className = "icon-group-end") 
	private WebElement toggleEyeIcon;
	
	public void ChangePassword(String oldPassword,String newPassword,String confirmNewPassword) {
		oldPasswordField.sendKeys(oldPassword);
		newPasswordField.sendKeys(newPassword);
		confirmNewPasswordField.sendKeys(confirmNewPassword);
		toggleEyeIcon.click();
		submitBtn.click();
	}
	

}
