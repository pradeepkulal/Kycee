package org.intuitiveapps.Kycee.AbstractComponents;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartPageBtn;
	@FindBy(xpath ="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersPageBtn;
	@FindBy(className ="Toastify__toast-body")
	WebElement toastMessage;
	@FindBy(className = "tooltip-customize")
	WebElement validationMessage;

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	 public static void selectOptionByText(WebElement dropdownElement, String visibleText) {
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(visibleText);
	    }
	  public void moveCursorToWebElement( WebElement element, int timeOutInSeconds){
	        awaitForElementPresence(driver, element, timeOutInSeconds);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).build().perform();
	        waitForSeconds(2);
	    }

	  public boolean awaitForElementPresence(WebDriver driver, WebElement element, int timeOutInSeconds){
	        try {
            waitForElementVisibility(driver, element, timeOutInSeconds);
	            return true;
	        }catch (Exception e){
	            return false;
	        }
	    }
	  private WebElement waitForElementVisibility(WebDriver driver, WebElement element, int timeOutInSeconds){
	        return (new WebDriverWait(driver , Duration.ofSeconds(timeOutInSeconds))).until(
	                ExpectedConditions.visibilityOf(element));
	        }
	  public void waitForSeconds(int second){
	        try{
	            Thread.sleep(second * 1000L);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	  
	  public String getToastMessage() {
		  waitForElementVisibility(driver,toastMessage , 1);
		return toastMessage.getText();
		
	}
	  public String getValidationMessage() {
		  waitForElementVisibility(driver,validationMessage , 1);
		return validationMessage.getText();
		
	}


}
