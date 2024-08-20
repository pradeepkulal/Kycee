package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.ForgotPasswordPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.ProfilePage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.TestComponents.Retry;
import org.intuitiveapps.Kycee.Utilities.ConfigurationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	@Test(priority = 0)
	public void loginWithSuperAdmin() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage dBPage= loginPage.login("Super Admin");
		ProfilePage profilePage=dBPage.goToProfilePage();
		AbstractComponents.verifyTextOfthWebEement(profilePage.getUserType(),"Super Admin");
	}

	@Test(priority = 1)
	public void loginWithCustomer() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage dBPage= loginPage.login("Customer");
		ProfilePage profilePage=dBPage.goToProfilePage();
		AbstractComponents.verifyTextOfthWebEement(profilePage.getUserType(),"Customer");
	}

	@Test(priority = 2)
	public void loginWithBusinessAdmin() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage dBPage= loginPage.login("Business Admin");
		ProfilePage profilePage=dBPage.goToProfilePage();
		AbstractComponents.verifyTextOfthWebEement(profilePage.getUserType(),"Admin");
	}

	@Test(priority = 3)
	public void loginWithBusinessUser() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage dBPage= loginPage.login("Business User");
		ProfilePage profilePage=dBPage.goToProfilePage();
		AbstractComponents.verifyTextOfthWebEement(profilePage.getUserType(),"User");
	}

	@Test(priority = 4)
	public void loginWithBlogger() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage dBPage= loginPage.login("Blogger");
		ProfilePage profilePage=dBPage.goToProfilePage();
		AbstractComponents.verifyTextOfthWebEement(profilePage.getUserType(),"Blogger");
	}


	@Test(retryAnalyzer = Retry.class,priority = 5)
	public void loginWithInvalidEmail() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("admin@sa.com", "#Abcdefgh11$");
		ConfigurationData configData = new ConfigurationData();
		AbstractComponents.verifyTextOfthWebEement(loginPage.getToastMessage(), configData.expectedNotRegisteredEmailIDNotifyMsg);
	}

	@Test(retryAnalyzer = Retry.class,priority = 6)
	public void loginWithInvalidPassword() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("admin@intuitiveapps.com", "#Abcdefgh1$");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getToastMessage(), "Incorrect password.");
	}

	@Test(retryAnalyzer = Retry.class,priority = 7)
	public void loginWithInvalidEmailFormat() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("admin.com", "#Abcdefgh1$");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getValidationMessage(), "The email address provided is not valid.");
	}

	@Test(retryAnalyzer = Retry.class,priority = 8)
	public void loginWithEmptyEmail() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("", "#Abcdefgh1$");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getValidationMessage(), ConfigurationData.expectedEmptyEmailFieldErrorMsg);
	}
	@Test(retryAnalyzer = Retry.class,priority = 8)
	public void loginWithEmptyPassword() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("admin@intuitiveapps.com", "");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getValidationMessage(), "Please provide a valid password.");
	}

	@Test(retryAnalyzer = Retry.class,priority = 9)
	public void loginWithInActiveUser() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("karthik.v@yopmail.com", "Test@1234");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getToastMessage(), "This user has been inactive. Please contact support.");
	}


	@Test(retryAnalyzer = Retry.class,priority = 10)
	public void loginWithInTerminatedUser() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		loginPage.loginApplication("rohith.g@yopmail.com", "Test@123");
		AbstractComponents.verifyTextOfthWebEement(loginPage.getToastMessage(), "This user has been terminated. Please contact support.");
	}
	
	@Test(retryAnalyzer = Retry.class,priority = 11)
	public void navigationToForgotPasswordPage() throws InterruptedException {
		LoginPage loginPage = homePage.validateSignInButton();
		ForgotPasswordPage forgotPasswordPage= loginPage.gotoForgotPasswordPage();
		AbstractComponents.verifyTextOfthWebEement(forgotPasswordPage.isTitleDisplayed(),ConfigurationData.expectedNewAccountCreationSuccessNotificationMessage);
	}
}