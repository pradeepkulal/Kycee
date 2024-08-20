package org.intuitiveapps.Kycee.Tests;


import java.io.IOException;

import org.intuitiveapps.Kycee.PageObjects.ChangePasswordPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
	String EmailID="nickyparker@bsgdulpk.mailosaur.net";
	String passWord1="Test@123";
	String passWord2="Test@1234";
	String passWord3="Test@12345";
	String passWord4="Test@123456";
	@Test
	public void changePasswordWithMismatchedPasswordAndConfirmPassword() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord4,passWord2, passWord3);
		Assert.assertEquals(cp.getValidationMessage(),"The confirmation password should match the original password.");
	}
	@Test
	public void changePasswordWithEmptyNewPasswordField() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord4,"", passWord3);
		Assert.assertEquals(cp.getValidationMessage(),"Please enter the valid new password.");
	}
	@Test
	public void changePasswordWithEmptyConfirmNewPasswordfield() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord4,passWord3,"" );
		Assert.assertEquals(cp.getValidationMessage(),"Please confirm your password and ensure it matches the original.");
	}
	@Test
	public void changePasswordWithEmptyOldPasswordfield() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword("",passWord3, passWord4);
		Assert.assertEquals(cp.getValidationMessage(),"Please enter the valid new password.");
	}
	@Test
	public void changingPasswordWithInvalidOldPassword() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord4,passWord2, passWord2);
		System.out.println(cp.getToastMessage());
		Assert.assertEquals(cp.getToastMessage(),"Old password is incorrect.");
	}
	@Test(dependsOnMethods = {"changingPasswordWithInvalidOldPassword"})
	public void successfullyChangingPassword() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord1,passWord2, passWord2);
		System.out.println(cp.getToastMessage());
		Assert.assertEquals(cp.getToastMessage(),"Password changed.");
	}
	@Test(dependsOnMethods = {"successfullyChangingPassword"})
	public void ChangingPasswordWithinFiveMinutes() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord2);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord2,passWord3,passWord3);
		System.out.println(cp.getToastMessage());
		if (cp.getToastMessage().getText().contains("before making another change password request.")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	@Test(dependsOnMethods = {"successfullyChangingPassword","ChangingPasswordWithinFiveMinutes"})
	public void successfullyChangingPasswordAfterFifteenMinutes() throws InterruptedException, IOException {
	
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord2);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		Thread.sleep(100000);
		cp.ChangePassword(passWord2,passWord3, passWord3);
		Assert.assertEquals(cp.getToastMessage(),"Password changed.");
	}
	
	@Test(dependsOnMethods = {"successfullyChangingPassword","successfullyChangingPasswordAfterFifteenMinutes"})
	public void changePasswordUsingLastThreePassword() throws InterruptedException, IOException {
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord3);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord3,passWord3, passWord3);
		Assert.assertEquals(cp.getToastMessage(),"New password can't match the last 3 passwords.");
		Thread.sleep(50000);
		cp.ChangePassword(passWord3,passWord4, passWord4);
		Assert.assertEquals(cp.getToastMessage(),"Password changed.");
	}
	
	@Test(dependsOnMethods = {"successfullyChangingPassword","successfullyChangingPasswordAfterFifteenMinutes","changePasswordUsingLastThreePassword"})
	public void changePasswordThreeTimesWithinTwentyFourHours() throws InterruptedException, IOException {
		
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord3);
		ChangePasswordPage cp=db.goToChangePasswordPage();
		cp.ChangePassword(passWord3,passWord4, passWord4);
		if (cp.getToastMessage().getText().contains("You can only change your password 3 times a day.")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	@Test(dependsOnMethods = {"successfullyChangingPassword"})
	public void LoginWithOldPaswordTest() throws InterruptedException, IOException {
		
		LoginPage loginPage = homePage.validateSignInButton();
		DashBoardPage db=loginPage.loginApplication(EmailID, passWord1);
		Assert.assertEquals(loginPage.getToastMessage(),"Incorrect password.");
	}

}
