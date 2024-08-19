package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.ForgotPasswordPage;
import org.intuitiveapps.Kycee.PageObjects.ProfilePage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.TestComponents.Retry;
import org.intuitiveapps.Kycee.Utilities.ConfigurationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
  @Test
  public void loginWithSuperAdmin() throws InterruptedException {
	 DashBoardPage dBPage= loginPage.loginApplication("admin@intuitiveapps.com", "#Abcdefgh12$");
	  ProfilePage profilePage=dBPage.goToProfilePage();
	  Assert.assertEquals(profilePage.getUserType(),"Super Admin");
  }
  @Test
  public void loginWithCustomer() throws InterruptedException {
	 DashBoardPage dBPage= loginPage.loginApplication("pradeep.k@yopmail.com", "Test@123456");
	  ProfilePage profilePage=dBPage.goToProfilePage();
	  Assert.assertEquals(profilePage.getUserType(),"Customer");
  }
  @Test
  public void loginWithBusinessAdmin() throws InterruptedException {
	 DashBoardPage dBPage= loginPage.loginApplication("jagesh.g@yopmail.com", "Test@123");
	  ProfilePage profilePage=dBPage.goToProfilePage();
	  Assert.assertEquals(profilePage.getUserType(),"Admin");
  }
  @Test
  public void loginWithBusinessUser() throws InterruptedException {
	 DashBoardPage dBPage= loginPage.loginApplication("praveen.k1@yopmail.com", "Test@1234");
	  ProfilePage profilePage=dBPage.goToProfilePage();
	  Assert.assertEquals(profilePage.getUserType(),"User");
  }
  @Test
  public void loginWithBlogger() throws InterruptedException {
	 DashBoardPage dBPage= loginPage.loginApplication("sanjana@intuitiveapps.com", "Test@123456");
	  ProfilePage profilePage=dBPage.goToProfilePage();
	  Assert.assertEquals(profilePage.getUserType(),"Blogger");
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithInvalidEmail() throws InterruptedException {
	  loginPage.loginApplication("admin@sa.com", "#Abcdefgh11$");
	  ConfigurationData configData = new ConfigurationData();
	  Assert.assertEquals(loginPage.getToastMessage(), configData.expectedNotRegisteredEmailIDNotifyMsg);
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithInvalidPassword() throws InterruptedException {
	  loginPage.loginApplication("admin@intuitiveapps.com", "#Abcdefgh1$");
	  Assert.assertEquals(loginPage.getToastMessage(), "Incorrect password.");
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithInvalidEmailFormat() throws InterruptedException {
	  loginPage.loginApplication("admin.com", "#Abcdefgh1$");
	  Assert.assertEquals(loginPage.getValidationMessage(), "The email address provided is not valid.");
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithEmptyEmail() throws InterruptedException {
	  loginPage.loginApplication("", "#Abcdefgh1$");
	  ConfigurationData configData = new ConfigurationData();
	  Assert.assertEquals(loginPage.getValidationMessage(), configData.expectedEmptyEmailFieldErrorMsg);
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithEmptyPassword() throws InterruptedException {
	  loginPage.loginApplication("admin@intuitiveapps.com", "");
	  Assert.assertEquals(loginPage.getValidationMessage(), "Please provide a valid password.");
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithInActiveUser() throws InterruptedException {
	  loginPage.loginApplication("karthik.v@yopmail.com", "Test@1234");
	  Assert.assertEquals(loginPage.getToastMessage(), "This user has been inactive. Please contact support.");
  }
  @Test(retryAnalyzer = Retry.class)
  public void loginWithInTerminatedUser() throws InterruptedException {
	  loginPage.loginApplication("rohith.g@yopmail.com", "Test@123");
	  Assert.assertEquals(loginPage.getToastMessage(), "This user has been terminated. Please contact support.");
}
  @Test(retryAnalyzer = Retry.class)
  public void navigationToForgotPasswordPage() throws InterruptedException {
	  ForgotPasswordPage forgotPasswordPage= loginPage.gotoForgotPasswordPage();
	  Assert.assertEquals(forgotPasswordPage.isTitleDisplayed(), "Forgot Password");
}
}