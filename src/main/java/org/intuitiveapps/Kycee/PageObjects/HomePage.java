package org.intuitiveapps.Kycee.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends AbstractComponents {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath ="//a[text()='Sign In']") 
	private WebElement signInBtn;
	@FindBy(xpath="//a[contains(@class,'me-3 btn-headers')]") 
	private WebElement signUpBtn;
	@FindBy(xpath="//h3") 
	private WebElement pageHeader;
	
	public void goTo() throws IOException {
		Properties prop =new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
		prop.load(fis);
		String serverName=prop.getProperty("Server");
		if (serverName.equalsIgnoreCase("QA")) {
			driver.get("https://qa.kycee.in");
		}else if (serverName.equalsIgnoreCase("DEV")) {
			driver.get("https://dev.kycee.in");
		}
	}
	
	public LoginPage validateSignInButton() {
		verifyBackGroundColorOfTheElement(signInBtn, expectedDarkBlueColor);
		if (isElementClickable(signInBtn)) {
			Assert.assertTrue(true); 
			System.out.println("Sign in button is clickable");
		}else {
			System.out.println("Sign in Button is not Clickable"); 
		}
		AbstractComponents.clickElement(signInBtn);
		if (isElementDisplayed(pageHeader)) {
			System.out.println("Successfully navigated to SignIn Page");
			Assert.assertTrue(true);
		}else { 
			System.out.println("Error in Navigation to SignIn page");
		}

		return new LoginPage(driver);
	}

	public SignUpPage validateSignUpButton() {
		verifyBackGroundColorOfTheElement(signInBtn, expectedDarkBlueColor);	
		if (isElementClickable(signUpBtn)) {
			Assert.assertTrue(true);
			System.out.println("Sign Up button is clickable");
		}else {
			System.out.println("Sign Up Button is not Clickable");
		}
		clickElement(signUpBtn);

		if (isElementDisplayed(pageHeader)) { 
			System.out.println("Successfully navigated to SignUp Page");
			Assert.assertTrue(true);
		}else {
			System.out.println("Error in Navigation to SignUp page");
		}
		return new SignUpPage(driver);
	}
}
