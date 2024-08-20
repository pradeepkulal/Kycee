package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends AbstractComponents{

	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "text-capitalize") private WebElement userType;
	
	
	public WebElement getUserType() {
		waitForWebElementToAppear(userType);
		return userType;
	}
}
