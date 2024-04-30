package org.intuitiveapps.Kycee.Tests;


import org.intuitiveapps.Kycee.PageObjects.CreateVerificationsPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.VerificationsListingPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;

public class CreateVerificationsTest extends BaseTest {

	@Test
	public void createVerificationsTest() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.loginApplication("karthik.v@yopmail.com", "Test@1234567");
		DashBoardPage dP=new DashBoardPage(driver);
		dP.gotoVerificationsListingPage();
		VerificationsListingPage vLP= new VerificationsListingPage(driver);
		vLP.clickOnNewButton();
		CreateVerificationsPage createVP= new CreateVerificationsPage(driver);
		createVP.createVerifications("sharada","k", "sharada.k@yopmail.com", "9900671321");
		
	}

}
