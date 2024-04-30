package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage  extends AbstractComponents {
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		@FindBy(id  ="verifications") 
		private WebElement verificationsPage;
		@FindBy(css   ="#users") 
		private WebElement usersPage;
		@FindBy(id  ="dropdown-profile") 
		private WebElement dropdown_profile;
		@FindBy (xpath = "(//a[@class='dropdown-item'])[2]")
		private WebElement changePasswordLink;
		@FindBy (id = "dashboard")
		private WebElement dashBoardPage;
		
		
		
		
		public void gotoVerificationsListingPage() {
			verificationsPage.click();
	}
		public void gotoUsersPage() {
			usersPage.click();
		}
		public void gotoDashBoardPage() {
			moveCursorToWebElement(dashBoardPage, 5);
			dashBoardPage.click();
		}
		public void goToChangePasswordPage() {
			waitForWebElementToAppear(dropdown_profile);
			dropdown_profile.click();
			changePasswordLink.click();
		}
}
