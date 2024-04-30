package org.intuitiveapps.Kycee.Tests;

import java.util.ArrayList;
import java.util.List;

import org.intuitiveapps.Kycee.Utilities.EmailUilities;

public class testingclass {
public static void main(String[] args) throws InterruptedException {
	EmailUilities email=new EmailUilities("shashi.k@yopmail.com");
	email.launchEmail();
	String OTP=email.getOTP();
	System.out.println(OTP);
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
    System.out.println(digits);
    
}
}
