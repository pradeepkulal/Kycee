package org.intuitiveapps.Kycee.Tests;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.intuitiveapps.Kycee.PageObjects.SignUpPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.intuitiveapps.Kycee.Utilities.ConfigurationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
	AbstractComponents abstractC = new AbstractComponents(driver);
	@Test(priority = 0)
	public void validateErrorMessageInSignUpPage() throws InterruptedException {
		SignUpPage sp = homePage.validateSignUpButton();
		sp.fillTheSignUpForm("", "", "", "", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedFirstNameValidationMessage);
		sp.fillTheSignUpForm("subhas",  "", "", "", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedLastNameValidationMessage);
		sp.fillTheSignUpForm("subhas", "s", "", "", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedEmptyEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@.com",  "", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.",  "", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidEmailFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "12312",  "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedInvalidInvalidPhoneNumberErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedEmptyPasswordFieldErrorMsg);
		sp.fillTheSignUpForm("subhas", "s", "subhashs1@yopmail.com", "9901299024", "Test@123", "");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(), ConfigurationData.expectedEmptyConfirmPasswordFieldErrorMsg);
		sp.fillTheSignUPForm("subhashs", "shetti", "subhashs1@yopmail.com", "9901299024", "Test@123", "Test@123", "", "",
				"GSTIN8596043640866");
		AbstractComponents.verifyTextOfthWebEement(sp.getValidationMessage(),ConfigurationData.expectedCompanyNameValidationMessage );
	}
	
	
	@Test(priority = 2)
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

	@Test(priority = 1)
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


	@Test(priority = 3)
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
