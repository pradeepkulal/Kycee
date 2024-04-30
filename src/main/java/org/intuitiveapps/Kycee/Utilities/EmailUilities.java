package org.intuitiveapps.Kycee.Utilities;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailUilities  {
	String EmailID= null;
	public WebDriver emailDriver;
	public EmailUilities(String EmailID) {
		this.EmailID=EmailID;
		this.emailDriver =emailDriver;
		PageFactory.initElements(emailDriver,this);
	}
	
	@FindBy(id = "login")  WebElement emailField;
	@FindBy(id = "refresh")  WebElement refreshBtn;
	@FindBy(xpath = "(//div[text()='KYCEE: Account Activation via OTP'])[1]")  WebElement accountactivationOTP_1;
	@FindBy(xpath = "(//div[text()='KYCEE: Account Activation via OTP'])[2]")  WebElement accountactivationOTP_2;
	@FindBy(xpath = "(//div[text()='KYCEE: Generate Password'])[1]")  WebElement generatePasswordEmail_1;
	@FindBy(xpath = "(//div[text()='KYCEE: Generate Password'])[2]")  WebElement generatePasswordEmail_2;
	@FindBy(xpath = "//span[contains(text(),'Generate')]") WebElement generatePasswordLink;
	
	public void launchEmail() {
	WebDriverManager.chromedriver().setup();
	emailDriver=new ChromeDriver();
	emailDriver.manage().window().maximize();
	//emailDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
	emailDriver.get("https://yopmail.com/en/");
	emailDriver.findElement(By.id("login")).sendKeys(EmailID);
	emailDriver.findElement(By.id("login")).sendKeys(Keys.ENTER);
}
	public void refreshInbox() {
		emailDriver.findElement(By.id("refresh")).click();
	}
	public String getGeneratePasswordLink() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("------------------------------------");
		int size = emailDriver.findElements(By.tagName("iframe")).size();
		emailDriver.switchTo().frame("ifinbox");
	WebElement w1=	emailDriver.findElement(By.xpath("(//div[@class= 'm']//button[@class='lm']//div[contains(text(),'KYCEE: Generate Password')])[1]"));
	w1.click();
	emailDriver.switchTo().defaultContent();
	emailDriver.switchTo().frame("ifmail");
	return emailDriver.findElement(By.xpath("//a[contains(@href,'setpassword')]")).getAttribute("href");
	}
	
	public String getOTP() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("------------------------------------");
		int size = emailDriver.findElements(By.tagName("iframe")).size();
		emailDriver.switchTo().frame("ifinbox");
	WebElement w1=	emailDriver.findElement(By.xpath("(//div[@class= 'm']//button[@class='lm']//div[contains(text(),'KYCEE: Account Activation via OTP')])[1]"));
	w1.click(); 
	emailDriver.switchTo().defaultContent();
	emailDriver.switchTo().frame("ifmail");
	String OTP= emailDriver.findElement(By.cssSelector("tbody tr td div div p strong span span")).getText();
	return OTP;
	}
	
	
	
	 public static List<Character> convertOTP_to_digits(String OTP) {
		 // Custom input string
		    String str = OTP;
		    // Creating array of string length
		    // using length() method
		    char[] ch = new char[str.length()];
		    // Copying character by character into array
		    // using for each loop
		    for (int i = 0; i < str.length(); i++) {
		        ch[i] = str.charAt(i);
		    }
		    // Printing the elements of array
		    // using for each loop
		    List<Character> digits= new ArrayList<Character>();
		    for (char c : ch) {
		    	digits.add(c); 
		}
		    return digits;
	}
	
	public void closeEmailWindow() {
		emailDriver.quit();
	}
}
