package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	@FindBy (xpath = "//a[text()=' Change Password']")
	private WebElement changePasswordLink;
	@FindBy (xpath = "(//a[@class='dropdown-item'])[1]")
	private WebElement profilePageLink;
	@FindBy (id = "dashboard")
	private WebElement dashBoardPage;
	@FindBy (xpath  = "//div[text()='Credits Available']/following-sibling::div")
	private WebElement creditsAvailableCount;

	@FindBy (xpath  = "(//div[@class='card-body'])[1]")
	private WebElement donationCard;
	@FindBy (xpath  = "(//div[@class='card-body'])[2]")
	private WebElement expensesCard;
	@FindBy (xpath  = "//h4")
	private WebElement pageHeader;


	public VerificationsListingPage gotoExpensesListingPage() {
		expensesCard	.click();
		return new VerificationsListingPage(driver);
	}

	public VerificationsListingPage gotoDonationListingPage() {
		donationCard.click();
		return new VerificationsListingPage(driver);
	}

	public VerificationsListingPage gotoVerificationsListingPage() {
		verificationsPage.click();
		return new VerificationsListingPage(driver);
	}

	public void gotoUsersPage() {
		usersPage.click();
	}

	public void gotoDashBoardPage() {
		moveCursorToWebElement(dashBoardPage, 5);
		dashBoardPage.click();
	}

	public ChangePasswordPage goToChangePasswordPage() throws InterruptedException {
		waitForElementToDisappear(loader);
		dropdown_profile.click();
		changePasswordLink.click();
		return new ChangePasswordPage(driver);
	}

	public ProfilePage goToProfilePage() throws InterruptedException {
		waitForElementToDisappear(loader);
		waitForSeconds(2);
		clickElement(dropdown_profile);
		clickElement(profilePageLink);
		String actualPageHeader = getTextOfWebElement(pageHeader);
		if (actualPageHeader.equals(myProfilePageHeaderText)) {
			Assert.assertTrue(true);
			System.out.println("User SuccessFully Naviagted to My profile page");
		} else {
			System.out.println("Naviagation to My profile page Failed");
			Assert.assertEquals(actualPageHeader, myProfilePageHeaderText,"Naviagation to My profile page Failed");
		}
		return new ProfilePage(driver);
	}

	public int getCreditsAvailableCount() {
		awaitForElementPresence(driver, creditsAvailableCount, 5);
		String count=creditsAvailableCount.getText();
		return Integer.parseInt(count);

	}
}
