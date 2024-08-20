package org.intuitiveapps.Kycee.AbstractComponents;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import org.intuitiveapps.Kycee.Resources.ExtentReporterNG;
import org.intuitiveapps.Kycee.Utilities.ConfigurationData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;


public class AbstractComponents extends ConfigurationData {
	static WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath =  "//div[contains(@class,'Toastify__toast ')]")
	public WebElement toastMessage;
	@FindBy(xpath = "//div[@class='tooltip-customize']")
	WebElement validationMessage;
	@FindBy(xpath = "//div[@class='loader']")
	public WebElement loader;
	@FindBy(id = "dashboard")
	public WebElement dashboardIcon;


	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public static void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}



	public void waitForLoaderToDisappear() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public static void selectOptionByText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public static void moveCursorToWebElement( WebElement element, int timeOutInSeconds){
		awaitForElementPresence(driver, element, timeOutInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static boolean awaitForElementPresence(WebDriver driver, WebElement element, int timeOutInSeconds){
		try {
			waitForElementVisibility(driver, element, timeOutInSeconds);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	private static WebElement waitForElementVisibility(WebDriver driver, WebElement element, int timeOutInSeconds){
		return (new WebDriverWait(driver , Duration.ofSeconds(timeOutInSeconds))).until(
				ExpectedConditions.visibilityOf(element));
	}

	public static void waitForSeconds(int second){
		try{
			Thread.sleep(second * 1000L);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public WebElement getToastMessage() throws InterruptedException {
		waitForWebElementToAppear(toastMessage);
		return  toastMessage;

	}
	
	public WebElement getValidationMessage() {
		  return validationMessage;
	}
	
	public Boolean isElementDisplayed(WebElement element) {
		return awaitForElementPresence(driver, element, timeOut);	
	}

	public void clickOnColumnHeader(String columnName) {
		WebElement element=driver.findElement(By.xpath(("//span[text()='"+columnName+"']")));
		awaitForElementPresence(driver, element, 5);
		element.click();
	}

	public void goToDashboardPageUsingNavigation() {
		moveCursorToWebElement(dashboardIcon, timeOut);
		dashboardIcon.click();
	}

	public void enterData(WebElement element, String textToSend) {
		try { 
			element.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.DELETE);
			element.sendKeys(textToSend);
		} catch (Exception e) {
			System.out.println("Error occured while inputing text int the field " + e.getMessage());
		}
	}

	public boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isNotClickable(WebElement... elements) {
		List<WebElement> elementsChecked = new ArrayList<>();
		List<WebElement> elementsToCheckByClass = new ArrayList<>();
		List<WebElement> elementsToCheckByClick = new ArrayList<>();
		List<WebElement> elementsToCheckBySendKeys = new ArrayList<>();

		for (WebElement checkedElement : elements) {
			if (checkedElement.isEnabled()) {
				elementsToCheckByClass.add(checkedElement);
			} else {
				elementsChecked.add(checkedElement);
			}
		}
		if (!elementsToCheckByClass.isEmpty()) {
			for (WebElement checkedByClassElement : elementsToCheckByClass) {
				String classOfElement = checkedByClassElement.getAttribute("class");
				List<String> classes = new ArrayList<>(Arrays.asList(classOfElement.split(" ")));
				if (!classes.contains("select2-container-disabled")) {
					elementsToCheckByClick.add(checkedByClassElement);
				} else {
					elementsChecked.add(checkedByClassElement);
				}
			}
		}
		if (!elementsToCheckBySendKeys.isEmpty()) {
			for (WebElement checkedBySendKeysElement : elementsToCheckBySendKeys) {
				try {
					checkedBySendKeysElement.sendKeys("checking");
					return false;
				} catch (Exception e) {
					elementsChecked.add(checkedBySendKeysElement);
				}
			}
		}
		return elementsChecked.size() == elements.length;
	}

	public boolean isElementClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,   Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void clickElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,   Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			System.out.println("The Button is not Clickable - " + e.getMessage());
		}
		waitForSeconds(2);
	}


	public static  String getTextOfWebElement(WebElement element) {
		waitForWebElementToAppear(element);
		return element.getText();
	}

	public List<String> getTextOfWebElements(List<WebElement> elements) {
		List<String> textOfAllWebElements = new ArrayList<>();
		for (WebElement element : elements) {
			textOfAllWebElements.add(element.getText());
		}
		return textOfAllWebElements;
	}

	public  String convertColorToHex(String cssValue,WebElement element) {
		waitForSeconds(1);
		String Css=element.getCssValue(cssValue);
		Color color = Color.fromString(Css);
		return color.asHex().toUpperCase();	
	}
	public  String getColorOfWebElement(String cssValue,WebElement element) {
		waitForSeconds(1);
		String Css=element.getCssValue(cssValue);
		Color color = Color.fromString(Css);
		return color.asHex().toUpperCase();	
	}

	public String convertColorToHex(String cssValue) {
		Color color = Color.fromString(cssValue);
		return color.asHex().toUpperCase();	
	}

	public void verifyTheLinksOfThePage(List<WebElement> links) {
		// TODO Auto-generated method stub

	}
	
	public void awaitForWebElementListLoad(List<WebElement> elementList, int timeOutInSeconds){
		for(int k = 0; k < timeOutInSeconds; k++){
			if(!(elementList.size() > 0)){
				waitForSeconds(1);
			}else {
				break;
			}
		}
	}

	public List<String> getListElementAttributeValue(List<WebElement> elements, String attributeValue){
		List<String> listElementText = new ArrayList<>();
		for (WebElement element : elements) {
			listElementText.add(element.getAttribute(attributeValue));
		}
		return listElementText;
	}


	public static void clickOnWebElements(List<WebElement> elements) {
		for (WebElement element : elements) {
			element.click();
		}
	}


	public  boolean awaitForElementPresence( WebElement element, int timeOutInSeconds){
		try {
			waitForElementVisibility(driver, element, timeOutInSeconds);
			return true;
		}catch (Exception e){
			return false;
		}
	}


	public void scrollToWebElement(WebDriver driver, WebElement element) {
		waitForSeconds(5);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();", element);
		waitForSeconds(5);
	}



	public String getTextOfWebElement(WebDriver driver,WebElement element) {
		awaitForElementPresence(element, timeOut);
		return element.getText();
	}

	public  void verifyBackGroundColorOfTheElement(WebElement ele, String expectedColor){
		String actualColor = convertColorToHex("background-color",ele);
		if (actualColor.equalsIgnoreCase(expectedColor)) {
			System.out.println(ele.getText() +" Color is Proper");
			Assert.assertTrue(true, actualColor);
		}else {
			System.out.println(ele.getText() +" Color is Not  Proper");
			String path = System.getProperty("user.dir")+ "\\ScreenShots\\" + ele.getText().concat(getCurrentTimeInString()) + ".png";
			takeScreenShot(ele, path);
		}
	}

	public  boolean verifyColorOfTheElement(WebElement ele, String expectedColor) {
		String actualColor = convertColorToHex("color",ele);

		if (actualColor.equalsIgnoreCase(expectedColor)) {
			System.out.println(ele.getText() +" Color is Proper");
			return true;
		}else {
			System.out.println(ele.getText() +" Color is Not  Proper");
			return false;
		}
	}

	public static String verifyTextOfthWebEement(WebElement ele, String expectedText) {
		waitForSeconds(2);
	//	moveCursorToWebElement(ele, timeOut);
		String actualText = getTextOfWebElement(ele);

		if (actualText.equals(expectedText)) {
			System.out.println(ele.getText() +" Text is proper");
			Assert.assertTrue(true, actualText);
			return ele.getText();
		}else {
			System.err.println("Actual Text:" + ele.getText());
			System.err.println("Expected Text:"+ expectedText);
			// Log the error in Extent Report
			ExtentReporterNG.logError(ele, actualText, expectedText);
			return ele.getText();
		}
	}


	public void assertNumericDataFromExcel(String actualCount,String cellData,String countOf) {
		double count = Double.valueOf(actualCount);
		int actualVerificationCount  = (int)count;
		double 	expectVerificationCount = Double.valueOf(cellData);
		int expectedVerificationCount  = (int)expectVerificationCount;
		if (actualVerificationCount == expectedVerificationCount) {
			System.out.println(countOf + " Count is correct");
		}else {
			Assert.assertEquals(actualVerificationCount, expectedVerificationCount, countOf + " Count is not correct");
		}
	}

	public void writeDataInExcel(String sheetName, String colName, int rowNum, String data){
		if (!data.isEmpty()) {
			testDataXL.setCellData(sheetName, colName,rowNum, data);
		}

	}

	public static void takeElementScreenShot(WebDriver driver,WebElement element,String filePath) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		Point p = element.getLocation();
		int x = p.getX();
		int y = p.getY();

		try {
			BufferedImage fullImg = ImageIO.read(screenshot);
			BufferedImage eleScreenShot = fullImg.getSubimage(x, y, width, height);
			ImageIO.write(eleScreenShot, "png", screenshot);
			File screenShotLocation = new File(filePath);
			FileHandler.copy(screenshot, screenShotLocation);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void takeScreenShot(WebElement element,String filePath) {
		File screenshot = element.getScreenshotAs(OutputType.FILE);

		// Define the destination path
		File destination = new File(filePath);

		// Copy the screenshot to the destination path
		try {
			FileHandler.copy(screenshot, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Screenshot saved successfully.");
	}

	public static String getCurrentTimeInString() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();
		// Define a formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		// Format the current date and time
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public static String getCurrentTime() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();
		// Define a formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
		// Format the current date and time
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public  List<String> getFirstRowDetails(WebElement ele) {
		awaitForElementPresence(ele, timeOut);
		String[] text= ele.getText().toLowerCase().split("\n");
		List<String> firstRowDetails= Arrays.asList(text);
		return firstRowDetails;
	}

	public void enterData(WebElement element, Keys enter) {
		try { 
			element.sendKeys(enter);
		} catch (Exception e) {
			System.out.println("Error occured while inputing Keys int the field " + e.getMessage());
		}	
	}

	public void uploadFile(String path) {
		WebElement ele = driver.findElement(By.xpath("//input[@type='file']"));
		ele.sendKeys(path);
	}

	public static String convertToRunningText(String sentence) {
		// Remove special characters (e.g., punctuation) and replace multiple spaces with a single space
		String runningText = sentence.replaceAll("[^a-zA-Z0-9 ]", "").replaceAll("\\s+", " ").trim();
		return runningText;
	}

	public static String capitalizeFirstLetter(String sentence) {
		if (sentence == null || sentence.isEmpty()) {
			return sentence;
		}

		// Convert the first character to uppercase and concatenate with the rest of the sentence
		return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
	}

	public static double roundToOneDecimalPlace(double value) {
		// Multiply by 10, round, then divide by 10
		return Math.round(value * 10) / 10.0;
	}
	public static double roundToTwoDecimalPlace(double value) {
		// Multiply by 10, round, then divide by 10
		return Math.round(value * 100) / 100.0;
	}
	public boolean compareToList(List<String> list1,List<String> list2) {
		Set<String> set2 = new HashSet<>(list2);

		for (String item : list1) {
			if (!set2.contains(item)) {
				return false;
			}
		}
		return true;
	}

	public void clearData(WebElement element) {
		try { 
			element.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.DELETE);
		} catch (Exception e) {
			System.out.println("Error occured while clearing text in the field " + e.getMessage());
		}		
	}

	public int getCount(WebElement element) {
		waitForWebElementToAppear( element);
		waitForSeconds(1);
		double 	UserCount = 0;
		if (element.getText().contains("Successful : ")) {
			try {
				UserCount = Double.valueOf(element.getText().replace("Successful : ", ""));
			} catch (NumberFormatException e) {
				waitForSeconds(2);
				UserCount = Double.valueOf(element.getText());
			}
		}else if(element.getText().contains("Not Successful :")) {
			try {
				UserCount = Double.valueOf(element.getText().replace("Not Successful :", ""));
			} catch (NumberFormatException e) {
				waitForSeconds(2);
				UserCount = Double.valueOf(element.getText());
			}
		}else
		{
			try {
				UserCount = Double.valueOf(element.getText().replace("Successful : ", ""));
			} catch (NumberFormatException e) {
				waitForSeconds(2);
				UserCount = Double.valueOf(element.getText());
			}
		}

		int userCount  = (int)UserCount;
		return userCount;
	}

	public int getIntValueOf(String countText) {
		waitForSeconds(2);
		double 	UserCount= Double.valueOf(countText);
		int userCount  = (int)UserCount;
		return userCount;
	}

	public String getFullName(String user) {
		String User = user.toLowerCase();
		String firstName = "";
		String secondName = "";
		switch (User) {
		case "customer":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 2);
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 2);
			break;
		case "new customer":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 7);
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 7);
			break;
		case "business user":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 3); 
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 3);
			break;

		case "new business user":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 9); 
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 9);
			break;
		case "business admin":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 4);
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 4);
			break;
		case "super admin":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 5);
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 5);
			break;
		case "blogger":
			firstName = testDataXL.getCellData("Sheet1", "First Name", 6);
			secondName = testDataXL.getCellData("Sheet1", "Last Name", 6);
			break;
		default:
			System.out.println(User + " is not available in the sheet");
			break;
		}
		String fullName = firstName+" "+secondName;
		return fullName;
	}

	public void updateTestDataOf(String userType,String email,String password,String firstName,String lastName,String verificationCount 
			,String successfullCount,String unsusccesfulCount,String creditsAvailable,String companyCredits,String walletId) {
		String User = userType.toLowerCase();
		int rowNum = 0;
		switch (User) {
		case "customer":
			rowNum =2;
			break;
		case "new customer":
			rowNum =7;
			break;
		case "business user":
			rowNum =3;
			break;

		case "new business user":
			rowNum =9;
			break;
		case "business admin":
			rowNum =4;
			break;
		case "new business admin":
			rowNum =8;
			break;
		case "super admin":
			rowNum =5;
			break;
		case "blogger":
			rowNum =6;
			break;
		default:
			System.out.println(User + " is not available in the sheet");
			break;
		}
		writeDataInExcel("sheet1", "Email", rowNum, email);
		writeDataInExcel("sheet1", "Password", rowNum, password);
		writeDataInExcel("sheet1", "First Name", rowNum, firstName);
		writeDataInExcel("sheet1", "Last Name", rowNum, lastName);
		writeDataInExcel("sheet1", "Verification Count", rowNum, verificationCount);
		writeDataInExcel("sheet1", "Successfull Verification Count", rowNum, successfullCount);
		writeDataInExcel("sheet1", "Unsuccessfull Verification Count", rowNum, unsusccesfulCount);
		writeDataInExcel("sheet1", "Creidits Available", rowNum, creditsAvailable);
		writeDataInExcel("sheet1", "Company Creidits", rowNum, companyCredits);
		writeDataInExcel("sheet1", "Wallet ID", rowNum, walletId);
	}

}
