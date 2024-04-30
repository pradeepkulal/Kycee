package org.intuitiveapps.Kycee.PageObjects;

import java.util.List;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcctivateAccountPage extends AbstractComponents {
	WebDriver driver;
	public AcctivateAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className  ="sc-eDvSVe") private WebElement activateAccountBtn;
	@FindBy(className ="sc-hLBbgP") WebElement logoutBtn;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[1]") WebElement OTPIn_1;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[2]") WebElement OTPIn_2;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[3]") WebElement OTPIn_3;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[4]") WebElement OTPIn_4;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[5]") WebElement OTPIn_5;
	@FindBy(xpath = "(//input[@class='otp-input-field form-control '])[6]") WebElement OTPIn_6;
	@FindBy(xpath = "//button[text()='Resend OTP']") WebElement resentOTP_Btn;
	
	public void ClckLogoutBtn() {
		logoutBtn.click();
	}
	public void clickActivateAccountBtn() {
		activateAccountBtn.click();
	}
	


	public void enterOTP(String otp) {
		 // Enter OTP digits using different locators
        for (int i = 0; i < 6; i++) {
            String otpDigit = String.valueOf(otp.charAt(i));
            String locator = getLocatorForDigit(i + 1);
            WebElement otpBox = driver.findElement(By.xpath(locator));
            otpBox.sendKeys(otpDigit);
        }
		
//		OTPIn_1.sendKeys(OTP1);
//		OTPIn_2.sendKeys(OTP2);
//		OTPIn_3.sendKeys(OTP3);
//		OTPIn_4.sendKeys(OTP4);
//		OTPIn_5.sendKeys(OTP5);
//		OTPIn_6.sendKeys(OTP6);		
	}
	 private static String getLocatorForDigit(int digitPosition) {
	         if (digitPosition == 1) {
	             return "(//input[@class='otp-input-field form-control '])[1]";
	         } else if (digitPosition == 2) {
	             return "(//input[@class='otp-input-field form-control '])[2]";
	         }else if (digitPosition == 3) {
	             return "(//input[@class='otp-input-field form-control '])[3]";
	         }else if (digitPosition == 4) {
	             return "(//input[@class='otp-input-field form-control '])[4]";
	         }else if (digitPosition == 5) {
	             return "(//input[@class='otp-input-field form-control '])[5]";
	         }else if (digitPosition == 6) {
	             return "(//input[@class='otp-input-field form-control '])[6]";
	         }
			return null;
	    }
	}
