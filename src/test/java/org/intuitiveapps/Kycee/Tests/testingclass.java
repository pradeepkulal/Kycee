package org.intuitiveapps.Kycee.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.intuitiveapps.Kycee.PageObjects.CreateVerificationsPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.VerificationsListingPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.Utilities.EmailUilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testingclass extends BaseTest{
@Test
public void testing() throws Exception {
	LoginPage loginPage = homePage.validateSignInButton();
	String firstName="suresh",lastName="Kulal", email="prakash.kula13@yopmail.com", phoneNumber="9900234123", type="email";
	DashBoardPage dashBoardPage= loginPage.loginApplication("karthik.v@yopmail.com", "Test@123");
	System.out.println(dashBoardPage.getCreditsAvailableCount());
	VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
	verificationListingPage.getFirstRowDetails();
	CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
	createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
	// System.out.println(createVerificationPage.getToastMessage());
	createVerificationPage.goBackToVerificationListingPage();
	System.out.println(verificationListingPage.getFirstRowDetails());
	boolean flag= verificationListingPage.checkIfVerificationIsCreated(firstName, lastName, phoneNumber, email, verificationListingPage.getFirstRowDetails());
	Assert.assertTrue(flag);
	verificationListingPage.goToDashboardPageUsingNavigation();
	System.out.println(dashBoardPage.getCreditsAvailableCount()); 
}

}
