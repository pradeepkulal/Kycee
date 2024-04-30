package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
  @Test
  public void loginWithSuperAdmin() throws InterruptedException {
	  lp.loginApplication("admin@intuitiveapps.com", "#Abcdefgh11$");
	  Assert.assertEquals(lp.getToastMessage(), "User logged in.");
  }
  
  @Test
  public void loginWithInvalidEmail() throws InterruptedException {
	  lp.loginApplication("admin@sa.com", "#Abcdefgh11$");
	  Assert.assertEquals(lp.getToastMessage(), "Email not associated with an account.");
  }
  @Test
  public void loginWithInvalidPassword() throws InterruptedException {
	  lp.loginApplication("admin@intuitiveapps.com", "#Abcdefgh1$");
	  Assert.assertEquals(lp.getToastMessage(), "Incorrect password.");
  }
  @Test
  public void loginWithInvalidEmailFormat() throws InterruptedException {
	  lp.loginApplication("admin.com", "#Abcdefgh1$");
	  Assert.assertEquals(lp.getValidationMessage(), "The email address provided is not valid.");
  }
  @Test
  public void loginWithEmptyEmail() throws InterruptedException {
	  lp.loginApplication("", "#Abcdefgh1$");
	  Assert.assertEquals(lp.getValidationMessage(), "Kindly enter a valid email address.");
  }

  @Test
  public void loginWithEmptyPassword() throws InterruptedException {
	  lp.loginApplication("admin@intuitiveapps.com", "");
	  Assert.assertEquals(lp.getValidationMessage(), "Please provide a valid password.");
  }
  
}
