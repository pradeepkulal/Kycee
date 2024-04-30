package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;

public class ErrorValidationsInLoginTest extends BaseTest {
	@Test
	public void LoginWithValidCredentials() {
		LoginPage lPage= new LoginPage(driver);
		lPage.loginApplication("ramagrawal2606@yopmail.com", "Test@123");
		
	}

}
