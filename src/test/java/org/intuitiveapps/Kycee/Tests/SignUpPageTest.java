package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.SignUpPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
  @Test
  public void SignUpTest() throws InterruptedException {
  SignUpPage sp=new SignUpPage(driver);
  sp.fillTheForm("subhash", "shetti", "subhashs@yopmail.com", "9901299001", "Test@123", "Test@123", "SUBHASH SHETTY pvt ltd", "CIN65453241233235",
		  "GSTIN85960436409");
  LoginPage lp= new LoginPage(driver);
  Thread.sleep(2000);
 // lp.loginApplication("karthik.v@yopmail.com", "Test@123");
  }
}
