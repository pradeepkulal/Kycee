package org.intuitiveapps.Kycee.PageObjects;

import javax.xml.xpath.XPath;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends AbstractComponents {
	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//h3[text()='Forgot Password']")
	private WebElement forgotPasswordPageTiitle;
	
	public boolean isTitleDisplayed() {
		return awaitForElementPresence(driver, forgotPasswordPageTiitle, 5);
	}

}
