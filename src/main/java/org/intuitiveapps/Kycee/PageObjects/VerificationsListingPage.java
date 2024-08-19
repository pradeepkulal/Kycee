package org.intuitiveapps.Kycee.PageObjects;

import java.util.stream.Stream;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.stream.Collectors;
import java.util.*;

public class VerificationsListingPage extends AbstractComponents {
	WebDriver driver;
	public VerificationsListingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className  ="sc-eDvSVe")
	public	WebElement newVerificationButton;
	@FindBy(xpath ="//div[@role='row']/div[@role='cell'][4]")
	public  List<WebElement> nameList;
	@FindBy(xpath ="(//div[@role='row'])[2]")
	public  WebElement firstRowListList;
	@FindBy(xpath ="//button[contains(@class,'sc-bcXHqe')]")
	public  WebElement newExpenseButton;
	
	
	
	public CreateVerificationsPage gotoCreateNewExpensePage() {
		awaitForElementPresence(driver, newExpenseButton, 5);
		newExpenseButton.click();
		return new CreateVerificationsPage(driver);
	}
	
	public void sortColumnInAscendingOrder(String ColumnName) {
		clickOnColumnHeader(ColumnName);
	}
	public CreateVerificationsPage gotoCreateNewVerificationPage() {
		awaitForElementPresence(driver, newVerificationButton, 5);
		newVerificationButton.click();
		return new CreateVerificationsPage(driver);
	}
	public  void getNameList() {
		awaitForElementPresence(driver, newVerificationButton, 5);
		for (WebElement webElement : nameList) {
			String text= webElement.getText();
			System.out.println(text);
		}
	}
	public  List<String> getFirstRowDetails() {
		
		awaitForElementPresence(driver, newVerificationButton, 5);
		
			String[] text= firstRowListList.getText().toLowerCase().split("\n");
		List<String> firstRowDetails= Arrays.asList(text);
		return firstRowDetails;
	}
	public boolean checkIfVerificationIsCreated(String firstName,String secondName,String phone,String email,List<String> firstRowDetails) {
		String fullName="";
		if (secondName.isEmpty()) {
			 fullName=firstName;
	}else {
		fullName=firstName+" "+secondName;
	}
		List<String> detailsList=new ArrayList<String>();
		detailsList.add(fullName.toLowerCase());
		detailsList.add(email);
		detailsList.add(phone);
		detailsList.add("pending");
		 for (String element : detailsList) {
			    if (!firstRowDetails.contains(element)) {
			      return false;
			    }
			  }
			  return true;
	}

}
