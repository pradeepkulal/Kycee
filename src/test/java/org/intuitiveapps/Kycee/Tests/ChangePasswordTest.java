package org.intuitiveapps.Kycee.Tests;

import java.time.Duration;

import org.intuitiveapps.Kycee.PageObjects.ChangePasswordPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
  @Test
  public void changepasswordTest() throws InterruptedException {
	  LoginPage lp=new LoginPage(driver);
	  lp.loginApplication("pradeep.k@yopmail.com", "Test@1234");
	  Thread.sleep(6000);
	  DashBoardPage db=new DashBoardPage(driver);
//	  db.goToChangePasswordPage();
//	  ChangePasswordPage cp=new ChangePasswordPage(driver);
//	  cp.ChangePassword("Test@123","Test@1234", "Test@1234");
//	  db.gotoDashBoardPage();
//	  Thread.sleep(500000);
	  db.goToChangePasswordPage();
	  ChangePasswordPage cp=new ChangePasswordPage(driver);
	  cp.ChangePassword("Test@1234","Test@12345", "Test@12345");
	  Thread.sleep(500000);
	  db.gotoDashBoardPage();
	  db.goToChangePasswordPage();
	  cp.ChangePassword("Test@12345","Test@123456", "Test@123456");
  }
}
 