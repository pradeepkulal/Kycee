package org.intuitiveapps.Kycee.Tests;

import java.io.IOException;
import java.util.Scanner;

import org.intuitiveapps.Kycee.PageObjects.AddBlogsPage;
import org.intuitiveapps.Kycee.PageObjects.BlogsPage;
import org.intuitiveapps.Kycee.PageObjects.LoginPage;
import org.intuitiveapps.Kycee.TestComponents.BaseTest;
import org.testng.annotations.Test;
public class createNewBlog extends BaseTest {

  @Test(invocationCount = 10)
  public void createNewBlogTest() throws InterruptedException, IOException {
	  Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter number");
	    String num = myObj.nextLine();  // Read user input
	  
	  AddBlogsPage addBlogsPage=new AddBlogsPage(driver);
	  addBlogsPage.addBlog("testing title "+num, "testing description "+ num,driver);
  }
}
