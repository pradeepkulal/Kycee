package org.intuitiveapps.Kycee.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//input[@type='email']") WebElement userEmailInput;
	@FindBy(xpath="//input[@type='password']") WebElement userPasswordInput;
	@FindBy(xpath="//input[@type='submit']") WebElement signInBtn;
	@FindBy(css=".Toastify__toast-body") WebElement ToastMsg;
	
	
	public DashBoardPage loginApplication(String email,String password) {
		userEmailInput.sendKeys(email);
		userPasswordInput.sendKeys(password);
		signInBtn.click();
		return new DashBoardPage(driver);
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
	public String getToastMsg() {
		waitForWebElementToAppear(ToastMsg);
		return ToastMsg.getText();
	}
}