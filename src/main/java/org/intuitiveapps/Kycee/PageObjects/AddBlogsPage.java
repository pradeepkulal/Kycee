package org.intuitiveapps.Kycee.PageObjects;

import java.io.IOException;
//import java.time.Duration;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.functions.Action;


public class AddBlogsPage extends AbstractComponents {
	WebDriver driver;
	private static final String INPUT_NAME = "file_upload";
	public AddBlogsPage(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='title']") private WebElement titleField;
	@FindBy(xpath = "//input[@name='image']") private WebElement imageUpload;
	@FindBy(className = "ql-editor") private WebElement descriptionField;
	@FindBy(className = "sc-eDvSVe") private WebElement submitBtn;

	
	public void addBlog(String title,String description, WebDriver driver) throws InterruptedException, IOException {
		titleField.sendKeys(title);
		descriptionField.sendKeys(description);
		System.out.println("Now");
		Actions act=new Actions(driver);
		act.click(imageUpload).build().perform();
	//	Runtime.getRuntime().exec("‪‪C:\\Users\\Intuitiveapps\\eclipse-workspace\\Kycee\\src\\main\\java\\org\\intuitiveapps\\Kycee\\AutoITScripts\\blogimageUpload.exe");
		
		submitBtn.click();
	}
}
