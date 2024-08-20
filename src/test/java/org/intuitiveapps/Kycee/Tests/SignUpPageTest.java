package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.PageObjects.SignUpPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.Utilities.ConfigurationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUpPageTest extends BaseTest {
	AbstractComponents abstractC = new AbstractComponents(driver);
	@Test(priority = 0)
	public void validateErrorMessageInSignUpPage() throws InterruptedException {
		SoftAssert sAssert = new SoftAssert();
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUpForm("", "", "", "", "", "");
		String n1 = ConfigurationData.expectedFirstNameValidationMessage;
		String n2 = ConfigurationData.expectedLastNameValidationMessage;
		String n3 = ConfigurationData.expectedEmptyEmailFieldErrorMsg;
		String n4 = ConfigurationData.expectedInvalidEmailFieldErrorMsg;
		String n5 = ConfigurationData.expectedInvalidInvalidPhoneNumberErrorMsg;
		String n6 = ConfigurationData.expectedEmptyPhoneNumberValidationMsg;
		String n7 = ConfigurationData.expectedEmptyPasswordFieldErrorMsg;
		String n8 = ConfigurationData.expectedEmptyConfirmPasswordFieldErrorMsg;
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedFirstNameValidationMessage),ConfigurationData.expectedFirstNameValidationMessage);
		sp.fillTheSignUpForm("subhas",  "", "", "", "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedLastNameValidationMessage),ConfigurationData.expectedLastNameValidationMessage);
		sp.fillTheSignUpForm("subhas", "s", "", "", "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidEmailFieldErrorMsg),ConfigurationData.expectedInvalidEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@.com",  "", "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidEmailFieldErrorMsg),ConfigurationData.expectedInvalidEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.",  "", "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidEmailFieldErrorMsg),ConfigurationData.expectedInvalidEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "12312",  "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), "Please enter a valid phone number."),ConfigurationData.expectedInvalidInvalidPhoneNumberErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), "Please provide a valid password."),"Password Error Message is not proper");
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "Test@123", "");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), "Please confirm your password and ensure it matches the original."),"Confirm password Error Message is not proper");
		sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "", "",
				"GSTIN8596043640866");
		sAssert.assertEquals(AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), "Please enter a valid company name."),"Company Name Error Message is not proper");
		sAssert.assertAll();
	}
	
	
	@Test(priority = 2,enabled = false)
	public void SignUpAsBusiessAdminWithValidData() throws InterruptedException {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email =(firstName + lastName + ConfigurationData.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.number().digits(10);
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = firstName + " " + lastName + " " + "Pvt Ltd";
		String cin_Number = "";
		String gstin_Number = "";
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUPForm(firstName, lastName, email,phoneNumber, password, confirmPassword, companyName, cin_Number,
				gstin_Number);
		AbstractComponents.verifyTextOfthWebEement(sp.toastMessage,ConfigurationData.expectedNewAccountCreationSuccessNotificationMessage);
		abstractC.updateTestDataOf("New Business Admin", email, password, firstName, lastName, 
				"0", "0", "0", "0", "0", "0");
	}

	@Test(priority = 1,enabled = false)
	public void SignUpAsCustumerWithValidData() throws InterruptedException {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email =(firstName + lastName + ConfigurationData.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.number().digits(10);
		String password = "Test@123";
		String confirmPassword = "Test@123";
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUpForm(firstName, lastName, email,phoneNumber, password, confirmPassword);
		AbstractComponents.verifyTextOfthWebEement(sp.toastMessage,ConfigurationData.expectedNewAccountCreationSuccessNotificationMessage);
		abstractC.updateTestDataOf("New Customer", email, password, firstName, lastName, 
				"0", "0", "0", "0", "0", "0");
	}


	@Test(priority = 3,enabled = false)
	public void SignUpAsBusiessAdminWithoutCIN() throws InterruptedException {
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "SUBHASH SHETTY s pvt ltd", "",
				"GSTIN8596043640866");
		System.out.println( sp.getToastMessage());
		Assert.assertEquals(sp.getToastMessage(), ConfigurationData.expectedNewAccountCreationSuccessNotificationMessage);
	}

	@Test(priority = 4,enabled = false)
	public void SignUpAsBusiessAdminWithoutGSTIN() throws InterruptedException {
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email =(firstName + lastName + ConfigurationData.serverDomain).replaceAll("'", "").toLowerCase();
		String phoneNumber = data.number().digits(10);
		String password = "Test@123";
		String confirmPassword = "Test@123";
		String companyName = firstName + " " + lastName + " " + "Pvt Ltd";
		String cin_Number = "";
		String gstin_Number = "";
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUPForm(firstName, lastName, email,phoneNumber, password, confirmPassword, companyName, cin_Number,
				gstin_Number);
		AbstractComponents.verifyTextOfthWebEement(sp.toastMessage,ConfigurationData.expectedNewAccountCreationSuccessNotificationMessage);
	}


}
