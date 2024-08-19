package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.PageObjects.SignUpPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
  @Test(enabled = false)
  public void SignUpAsBusiessAdminWithValidData() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "SUBHASH SHETTY s pvt ltd", "CIN6545324123323597875621",
		  "GSTIN8596043640866");
  System.out.println( sp.toastMessage.getText());
  Assert.assertEquals(sp.toastMessage.getText(), "New account created.");
  }
  @Test(enabled = false)
  public void SignUpAsCustumerWithValidData() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.toastMessage.getText());
  Assert.assertEquals(sp.toastMessage.getText(), "New account created.");
  }
  @Test
  public void SignUpWithoutFirstName() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please enter a valid first name.");
  }
  @Test
  public void SignUpWithoutLastName() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please enter a valid last name.");
  }
  @Test
  public void SignUpWithoutEmail() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Kindly enter a valid email address.");
  }
  @Test
  public void SignUpWithInvalidEmail1() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "subhashs1@.com", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Kindly enter a valid email address.");
  }
  @Test
  public void SignUpWithInvalidEmail12() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.", "9901299024", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Kindly enter a valid email address.");
  }
  @Test
  public void SignUpWithPhoneNumberLessThenTenDigits() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "12312", "Test@123", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please enter a valid phone number.");
  }
  @Test
  public void SignUpWithoutPassword() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "", "Test@123");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please provide a valid password.");
  }
  @Test
  public void SignUpWithoutConfirmPassword() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "Test@123", "");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please confirm your password and ensure it matches the original.");
  }
  @Test
  public void SignUpAsBusiessAdminWithoutCompanyName() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "", "CIN6545324123323597875621",
		  "GSTIN8596043640866");
  System.out.println( sp.getValidationMessage());
  Assert.assertEquals(sp.getValidationMessage(), "Please enter a valid company name.");
  }
  @Test
  public void SignUpAsBusiessAdminWithoutCIN() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "SUBHASH SHETTY s pvt ltd", "",
		  "GSTIN8596043640866");
  System.out.println( sp.getToastMessage());
  Assert.assertEquals(sp.getToastMessage(), "New account created.");
  }
  @Test
  public void SignUpAsBusiessAdminWithoutGSTIN() throws InterruptedException {
  SignUpPage sp=loginPage.gotosignUpPage();
  sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "SUBHASH SHETTY s pvt ltd", "CIN6545324123323597875621",
		  "");
  System.out.println( sp.getToastMessage());
  Assert.assertEquals(sp.getToastMessage(), "New account created.");
  }
  
  
}
