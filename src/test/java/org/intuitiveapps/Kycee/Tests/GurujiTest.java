package org.intuitiveapps.Kycee.Tests;

import java.util.concurrent.TimeUnit;

import org.intuitiveapps.Kycee.PageObjects.CreateVerificationsPage;
import org.intuitiveapps.Kycee.PageObjects.DashBoardPage;
import org.intuitiveapps.Kycee.PageObjects.VerificationsListingPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GurujiTest extends BaseTest{
	@Test(invocationCount = 105)
	public void createExpensesTest() {
		DashBoardPage dBPage= loginPage.loginApplication("admin@gurujibayarea.com", "Admin@123");
		VerificationsListingPage vlPage = dBPage.gotoDonationListingPage();
		CreateVerificationsPage cvPage =  vlPage.gotoCreateNewExpensePage();
		Faker data = new Faker();
		String firstName = data.name().firstName();
		String lastName = data.name().lastName();
		String email = firstName+lastName+ "@yopmail.com";
		String phoneNumber = data.phoneNumber().phoneNumber();
		Double amount = data.number().randomDouble(2, 0, 10000);
		String date = data.date().past(5, TimeUnit.DAYS).toString();
		int index = data.number().numberBetween(1,6);
		cvPage.createDonations(firstName,lastName, email,phoneNumber, amount,date,index);
	}

}
