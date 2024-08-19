package org.intuitiveapps.Kycee.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.text.html.FormSubmitEvent;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.intuitiveapps.Kycee.Utilities.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import kycee.PageEvent.DashBoardPageEvent;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath ="//input[@type='email']") 
	private WebElement userEmailInput;
	@FindBy(xpath="//input[@type='password']") 
	private WebElement userPasswordInput;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement signInBtn;
	@FindBy(xpath="//a[contains(@href,'forgotPassword')]")
	private WebElement forgotPasswordPageLink;
	@FindBy(xpath="//a[contains(@href,'signup')]")
	private WebElement signUpPageLink;
	@FindBy(xpath="//h4")
	private WebElement pageHeader;

	public DashBoardPage loginApplication(String email,String password) {
		userEmailInput.sendKeys(email);
		userPasswordInput.sendKeys(password);
		signInBtn.click();

		return new DashBoardPage(driver);
	}
	public ForgotPasswordPage gotoForgotPasswordPage() {
		forgotPasswordPageLink.click();
		return new ForgotPasswordPage(driver);
	}

	public void goTo() throws IOException {
		Properties prop =new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
		prop.load(fis);
		String serverName=prop.getProperty("Server");
		if (serverName.equalsIgnoreCase("QA")) {
			driver.get("https://qa.kycee.in/login");
		}else if (serverName.equalsIgnoreCase("DEV")) {
			driver.get("https://dev.kycee.in/login");
		}

	}
	
	public DashBoardPage login(String user) {
		String User = user.toLowerCase();
		String email = "";
		String password = "";
		switch (User) {
		case "customer":
			email = testDataXL.getCellData("Sheet1", "Email", 2);
			password = testDataXL.getCellData("Sheet1", "Password", 2);
			break;
		case "new customer":
			email = testDataXL.getCellData("Sheet1", "Email", 7);
			password = testDataXL.getCellData("Sheet1", "Password", 7);
			break;
		case "business user":
			email = testDataXL.getCellData("Sheet1", "Email", 3); 
			password = testDataXL.getCellData("Sheet1", "Password", 3);
			break;
			
		case "new business user":
			email = testDataXL.getCellData("Sheet1", "Email", 9); 
			password = testDataXL.getCellData("Sheet1", "Password", 9);
			break;
		case "business admin":
			email = testDataXL.getCellData("Sheet1", "Email", 4);
			password = testDataXL.getCellData("Sheet1", "Password", 4);
			break;
		case "super admin":
			email = testDataXL.getCellData("Sheet1", "Email", 5);
			password = testDataXL.getCellData("Sheet1", "Password", 5);
			break;
		case "blogger":
			email = testDataXL.getCellData("Sheet1", "Email", 6);
			password = testDataXL.getCellData("Sheet1", "Password", 6);
			break;
		default:
			System.out.println(User + " is not available in the sheet");
			break;
		}

		enterData(userEmailInput, email);
		enterData(userPasswordInput, password);
		clickElement(signInBtn);
		System.out.println(User + " is Successfully Logged In");
		if (User.equals("blogger")) {
			if (isElementDisplayed(pageHeader)) {
				verifyTextOfthWebEement(pageHeader, expectedBlogsPageHeader);
			}else {
				Assert.assertTrue(false,User + " Log In Failed");
			}
			return new DashBoardPage(driver);
		}else {
			if (isElementDisplayed(pageHeader)) {
				verifyTextOfthWebEement(pageHeader, expectedDashBoardHeader);
			}else {
				Assert.assertTrue(false,User + " Log In Failed");
			}
			return new DashBoardPage(driver);
		}
		
	}
	
	
	
	public String getToastMsg() {
		waitForElementToAppear(By.cssSelector(".Toastify__toast-container"));
		return toastMessage.getText();
	}
	public SignUpPage gotosignUpPage() {
		signUpPageLink.click();
		return new SignUpPage(driver);
	}

}