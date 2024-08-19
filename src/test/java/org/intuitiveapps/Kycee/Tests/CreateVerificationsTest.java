package org.intuitiveapps.Kycee.Tests;


import org.intuitiveapps.Kycee.PageObjects.CreateVerificationsPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.VerificationsListingPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateVerificationsTest extends BaseTest {
	String loginEmail="kashi.kds@yopmail.com";
	String password = "Test@123";
	
	@Test
	public void successFullyCreatingEmailTypeVerificationTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="prakash.kula137@yopmail.com", phoneNumber="9900234123", type="instant";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
	//	verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		 System.out.println(createVerificationPage.getToastMessage());
	//	createVerificationPage.goBackToVerificationListingPage();
		System.out.println(verificationListingPage.getFirstRowDetails());
		boolean flag= verificationListingPage.checkIfVerificationIsCreated(firstName, lastName, phoneNumber, email, verificationListingPage.getFirstRowDetails());
		Assert.assertTrue(flag);
		
	}
	@Test(dependsOnMethods = {"successFullyCreatingEmailTypeVerificationTest"})
	public void creatingEmailTypeVerificationWithAlreadyUsedEmailTest() throws InterruptedException {
		String firstName="suresh",lastName="Kulal", email="prakash.kula13@yopmail.com", phoneNumber="9900234123", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getToastMessage(), "A verification link has already been generated using this email.");		
	}
	@Test
	public void createVerificationWithoutFirstNameTest() throws InterruptedException {
		String firstName="",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="9108748776", type="whatsApp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "Please enter a valid first name.");
	}
	@Test
	public void createEmailTypeVerificationWithoutEmailIDTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "Kindly enter a valid email address.");
	}
	@Test
	public void createWhatsAppTypeVerificationWithoutEmailIDTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getToastMessage(), "A verification link has already been generated using this phone number.");
	}
	@Test
	public void createEmailTypeVerificationWithMissingDomainInEmailIDTest1() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="karthik.v@.com", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "The email address provided is not valid.");
	}
	@Test
	public void createEmailTypeVerificationWithOutAtSymbolinEmail() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="karthik.vyopmail.com", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "The email address provided is not valid.");
	}
	@Test
	public void createEmailTypeVerificationWithoutComInEmail() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="karthik.v@yopmail.", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "The email address provided is not valid.");
	}
	@Test
	public void createWhatsAppTypeVerificationWithoutPhoneNUmberTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="", type="whatsApp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "Please enter a valid phone number.");
	}
	@Test
	public void createEmailTypeVerificationWithoutPhoneNumberTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "Please enter a valid phone number.");
	}
	@Test
	public void createWhatsAppTypeVerificationWithPhoneNumberLessThen10CharactersTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="99990", type="whatsapp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getValidationMessage(), "Please enter a valid phone number.");
	}
	@Test
	public void createWhatsAppTypeVerificationWithUnregisteredPhoneNumberTest() throws InterruptedException {
		String firstName="pradeep",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="99990123456", type="whatsapp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		Assert.assertEquals(createVerificationPage.getToastMessage(), "Can not send the whatsapp message currently, please try again after sometime.");
	}
	@Test
	public void successFullyCreatingEmailTypeVerificationWithoutLastNameTest() throws InterruptedException {
		String firstName="suresh",lastName="", email="prakash123@yopmail.com", phoneNumber="9900234123", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		 System.out.println(createVerificationPage.getToastMessage());
		createVerificationPage.goBackToVerificationListingPage();
		System.out.println(verificationListingPage.getFirstRowDetails());
		boolean flag= verificationListingPage.checkIfVerificationIsCreated(firstName, lastName, phoneNumber, email, verificationListingPage.getFirstRowDetails());
		Assert.assertTrue(flag);
	}
	
	@Test
	public void successFullyCreatingWhatsAppTypeVerificationTest() throws InterruptedException {
		String firstName="suresh",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="9108748776", type="whatsApp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		verificationListingPage.getFirstRowDetails();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.createVerification(firstName,lastName, email, phoneNumber, type);
		createVerificationPage.goBackToVerificationListingPage();
		System.out.println(verificationListingPage.getFirstRowDetails());
		boolean flag= verificationListingPage.checkIfVerificationIsCreated(firstName, lastName, phoneNumber, email, verificationListingPage.getFirstRowDetails());
		Assert.assertTrue(flag);
	}
	
	@Test
	public void saveAndNextButtonForInstantVerificationTest() throws InterruptedException {
		String firstName="suresh",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="9108748776", type="instant";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.selectTypeOfVerification(type);
		Assert.assertEquals(createVerificationPage.getTextOfSubmitButton(),"Save & Next");
	}
	@Test
	public void submitButtonForEmailtVerificationTest() throws InterruptedException {
		String firstName="suresh",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="9108748776", type="email";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.selectTypeOfVerification(type);
		Assert.assertEquals(createVerificationPage.getTextOfSubmitButton(),"Submit");
	}
	@Test
	public void submitButtonForWhatsAppVerificationTest() throws InterruptedException {
		String firstName="suresh",lastName="Kulal", email="prakash13@yopmail.com", phoneNumber="9108748776", type="whatsapp";
		DashBoardPage dashBoardPage= loginPage.loginApplication(loginEmail, password);
		VerificationsListingPage verificationListingPage= dashBoardPage.gotoVerificationsListingPage();
		CreateVerificationsPage createVerificationPage= verificationListingPage.gotoCreateNewVerificationPage();
		createVerificationPage.selectTypeOfVerification(type);
		Assert.assertEquals(createVerificationPage.getTextOfSubmitButton(),"Submit");
	}

}
