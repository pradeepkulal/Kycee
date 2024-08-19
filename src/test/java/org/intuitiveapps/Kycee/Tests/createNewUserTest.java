package org.intuitiveapps.Kycee.Tests;

import java.time.Duration;

import org.intuitiveapps.Kycee.PageObjects.AcctivateAccountPage;
import org.intuitiveapps.Kycee.PageObjects.CreateUsersPage;
import org.intuitiveapps.Kycee.PageObjects.CreateVerificationsPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.GeneratePasswordPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.UsersListingPage;
import org.intuitiveapps.Kycee.PageObjects.VerificationsListingPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.Utilities.EmailUilities;
import org.testng.annotations.Test;

public class createNewUserTest extends BaseTest {
	private String adminEmail="pradeep123456@yopmail.com", adminPassword="Test@123",
			userFirstName="harisha",userLastName="shetty",userEmail="shetty.harisha34@yopmail.com";

	@Test
	public void createNewUser() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.loginApplication(adminEmail, adminPassword);
		DashBoardPage dP=new DashBoardPage(driver);
		dP.gotoUsersPage();
		UsersListingPage userLP=new UsersListingPage(driver);
		userLP.clickOnAddUsersButton();
		CreateUsersPage createUP= new CreateUsersPage(driver);
		createUP.createUsers(userFirstName,userLastName, userEmail, "9101234765","User", "0");
		EmailUilities email=new EmailUilities(userEmail);
		email.launchEmail();
		driver.get(email.getGeneratePasswordLink());
		GeneratePasswordPage gpPage=new GeneratePasswordPage(driver);
		gpPage.fillPassword(adminPassword, adminPassword);
		LoginPage lPage= new LoginPage(driver);
		lPage.loginApplication(userEmail, adminPassword);
		AcctivateAccountPage activateAccPage= new AcctivateAccountPage(driver);
		activateAccPage.clickActivateAccountBtn();
		activateAccPage.enterOTP(email.getOTP());
	}
	@Test(enabled= false)
	public void generatePassword() throws InterruptedException {
		EmailUilities email=new EmailUilities(userEmail);
		email.launchEmail();
		
		GeneratePasswordPage gpPage=new GeneratePasswordPage(driver);
		gpPage.fillPassword(adminPassword, adminPassword);
		LoginPage lPage= new LoginPage(driver);
		lPage.loginApplication(userEmail, adminPassword);
		AcctivateAccountPage activateAccPage= new AcctivateAccountPage(driver);
		activateAccPage.clickActivateAccountBtn();
		
		activateAccPage.enterOTP(email.getOTP());
	}
	@Test(enabled = false)
	public void OTP_Verification_Test() throws InterruptedException {
		EmailUilities email=new EmailUilities(userEmail);
		email.launchEmail();
		LoginPage lPage= new LoginPage(driver);
		lPage.loginApplication(userEmail, adminPassword);
		AcctivateAccountPage activateAccPage= new AcctivateAccountPage(driver);
		activateAccPage.clickActivateAccountBtn();
		activateAccPage.enterOTP(email.getOTP());
	}
	
}
