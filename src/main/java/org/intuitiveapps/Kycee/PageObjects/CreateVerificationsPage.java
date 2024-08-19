package org.intuitiveapps.Kycee.PageObjects;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVerificationsPage extends AbstractComponents {
	WebDriver driver;
	public CreateVerificationsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name  ="donator_first_name") WebElement firstNameInput;
	@FindBy(xpath  ="//input[@name='last_name']") WebElement lastNameInput;
	@FindBy(name = "donator_last_name") WebElement donator_last_name;
	@FindBy(xpath = "//input[@type='email']") WebElement emailIDInput;
	@FindBy(xpath = "//input[@name='phoneNumber']") WebElement phoneNumberInput;
	@FindBy(xpath = "//input[@name='donator_phone_number']") WebElement donator_phone_number;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitBtn;
	@FindBy(xpath = "(//label[@class='form-check-label'])[1]")
	private WebElement instantType;
	@FindBy(xpath = "(//label[@class='form-check-label'])[2]")
	private WebElement emailType;
	@FindBy(xpath = "(//label[@class='form-check-label'])[3]")
	private WebElement whatsAppType;
	@FindBy(css="[class*='Toastify__toast-body']") WebElement ToastMsg;
	@FindBy(css="div.back-with-title > svg") WebElement backIcon;
	@FindBy(xpath = "//input[@name='description']")
	private WebElement descriptionInput;
	@FindBy(xpath = "//input[@name='amount']")
	private WebElement amountInput;
	
	@FindBy(xpath = "(//input[@class='form-control'])[5]")
	private WebElement dateSelect;
	@FindBy(xpath = "//div[@class=' css-1jqq78o-placeholder']")
	private WebElement paySelect;
	
	public void createVerification(String firstName,String lastName,String emailID,String phoneNumber,String type) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailIDInput.sendKeys(emailID);
		phoneNumberInput.sendKeys(phoneNumber);
		selectTypeOfVerification(type);
		submitBtn.click();
	}
	
	public void createExpense(String firstName,String lastName,String descrption,String phoneNumber,Double amount, String date,int index) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		descriptionInput.sendKeys(descrption);
		phoneNumberInput.sendKeys(phoneNumber);
		amountInput.sendKeys(Double.toString(amount));
		dateSelect.sendKeys(date);
		Actions act = new Actions(driver);
		act.keyDown(Keys.ESCAPE).build().perform();
		paySelect.click();
		String xpat = "//div[@class=' css-10wo9uf-option']["+index +"]";
		driver.findElement(By.xpath(xpat)).click();;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submitBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createDonations(String firstName,String lastName,String emailID,String phoneNumber,Double amount,String date,int index) {
		firstNameInput.sendKeys(firstName);
		donator_last_name.sendKeys(lastName);
		emailIDInput.sendKeys(emailID);
		donator_phone_number.sendKeys(phoneNumber);
		amountInput.sendKeys(Double.toString(amount));
		dateSelect.sendKeys(date);
		Actions act = new Actions(driver);
		act.keyDown(Keys.ESCAPE).build().perform();
		paySelect.click();
		String xpat = "//div[@class=' css-10wo9uf-option']["+index +"]";
		driver.findElement(By.xpath(xpat)).click();;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectTypeOfVerification(String type) {
		if (type.equalsIgnoreCase("email")) {
			emailType.click();
		}else if (type.equalsIgnoreCase("whatsapp")) {
			whatsAppType.click();
		}else {
			instantType.click();
		}
	}
	public String getTextOfSubmitButton() {
	return	getTextOfWebElement(submitBtn);
	}
	
	public void goBackToVerificationListingPage() throws InterruptedException {
		waitForElementToDisappear(loader);
		awaitForElementPresence(driver, backIcon, 5);
			Thread.sleep(3000);
		backIcon.click();
	}
}
