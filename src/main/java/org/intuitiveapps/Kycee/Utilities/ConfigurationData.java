package org.intuitiveapps.Kycee.Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class ConfigurationData {
	public Xls_Reader testDataXL = new Xls_Reader(getLoginTestDataPath());
	public final static Xls_Reader	 notificationDataXL = new Xls_Reader(geterrorMessageExcelPath());
	public final static int timeOut=10;

	public static String geterrorMessageExcelPath() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =System.getProperty("user.dir")+prop.getProperty("errorMessageExcelPath");		
		return str;
	}

	public String getLoginTestDataPath() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =System.getProperty("user.dir")+ prop.getProperty("LoginTestDataPath");
		return str;
	}

	public static String getvalidationMessageExcelSheetName() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =prop.getProperty("validationMessageExcelSheet");
		return str;
	}

	public static String getnotificationMessageExcelSheetName() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("notificationMessageExcelSheet");
	}

	public static String getvalidationMessageColName() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = prop.getProperty("validationMessageColName");
		return prop.getProperty("validationMessageColName");
	}

	public static String getnotificationMessageColName() {
		Properties prop =new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("notificationMessageColName");
	}


	/*--------------------------Mail Functionality Configuaration--------------------*/	
	public static String mailosaurAPIKey = "56Kmwh3l9UyaZhd7mAwH31M4mtFuZwZz";
	public static String serverID = "bsgdulpk"; 
	public static String serverDomain = "@bsgdulpk.mailosaur.net";


	public static  String expectedNoDataToDisplayMessage = "No data is available to display";
	public static String BA_subhead_text = "Introduction 1";
	public static String domainText = "DOMAINS";
	public static String domain_Header_Text = "Domains We Serve";
	public static String business_Casses_Button_text ="BUSINESS CASES";
	public static String business_Casses_Header_Text= "Business Cases";
	public static String challenges_Button_text ="CHALLENGES";
	public static String challenges_Header_Text= "Challenges";
	public static String About_Us_Tab_Button_text ="ABOUT US";
	public static String Why_KYCEE_text = "WHY KYCEE";
	public static String expectedBeforeTextColor ="#8A90A2";
	public static String expectedAfterTextColor = "#292930";
	public static String expectedTitleList[] = {"About KYCee","Policies","Help & Support","Instagram post"};
	public static String expectedWhyKYCEEButtonText[] = {"Technology","Design","Innovation"};
	public static String expectedYellowColor ="#FBD95E";
	public static String expectedRatingYellowColor ="#FFA500";
	public static String expectedBusinessCasesCardText[] = {"Bulk Processing","Customer Onboarding","Account Recovery","Legal Signatures","Buying & Selling","Decision Making"};
	public static String expectedlightBlueColor ="#82CEFD";
	public static String expectedDarkBlueColor = "#5956E9";
	public String ExpectedRedButtonColor = "#DC3545";
	public static String expectedChallangesButtonText[] = {"Expectations","User Experience","Regulatory","Manual Processes","Data Quality","Evolving Fraud"};
	public static String expectedAIButtonText = "AI'S Magic";
	public static String About_Us_Button_text ="About Us";
	public static String expectedFirstNameValidationMessage = "Please enter a valid first name.";
	public static String expectedLastNameValidationMessage = "Please enter a valid last name.";
	public static String expectedEmailValidationMessage = "Kindly enter a valid email address.";
	public static String expectedCompanyNameValidationMessage = "Please enter a valid company name.";
	public static String expectedDuplicateEmailErrorNotification = "Email address is already in use by another user. Please enter a different email address.";
	public static String expectedSuccessfullAccountNotification = "Account created successfully.";
	public static String expectedDuplicatePhoneNumberErrorNotification = "Phone number already in use.";
	public static String expectedDuplicateCompanyNameErrorNotification = "The company name is already in use by another account. Please choose a different company name.";
	public static String expectedWhiteColor = "#FFFFFF";
	public String expectedGreyColor = "#E2E2E2";
	public static String expectedSlateGrayColor = "#687587";
	//------------------------------------------------------Sign in Page Data --------------------------------//
	public String ExpectedSignInPageHeader = "Sign In";
	//------------------------------------------------------Sign Up Page Data --------------------------------//
	public String ExpectedSignUpPageHeader = "Sign Up";


	//------------------------------------------------------Forgot Password Page Data --------------------------------//
	public static String forgotPasswordHeaderText = "Forgot Password";
	public String ExpectedResetPasswordPageHeader = "Reset Password";

	//------------------------------------------------------DashBoard Page Data --------------------------------//
	public String expectedDashBoardHeader ="Dashboard";
	public String expectedWalletTitle = "Wallet";
	public String expectedVerificationTitle = "Verification";

	//------------------------------------------------------My Profile Page Data --------------------------------//
	public static String myProfilePageHeaderText = "My Profile";
	public String validImageAutoITPath = "C://Users//Intuitiveapps//eclipse-workspace//Kyce//src//main//resources//validPNGUpload.exe";
	public String validPNGFIle = "C://Users//Intuitiveapps//eclipse-workspace//Kyce//src//main//resources//validProfilePhot.png";
	public String invalidPNGFIle = "C://Users//Intuitiveapps//eclipse-workspace//Kyce//src//main//resources//LoginTestData.xlsx";
	public String expectedEmailActivationPopUpHeader = "Email Activation";
	//------------------------------------------------------Users Page Data --------------------------------//
	public static  String ExpectedUserPageHeader = "Users";
	public String expectedAddUserHeader = "Add User";

	//------------------------------------------------------Generate Password Page Data --------------------------------//
	public String ExpectedGeneratePasswordPageHeader = "Generate Password";
	public String expectedPageExpiredText = "Uh oh. This link has expired.";

	//------------------------------------------------------Activate Account Page Data --------------------------------//
	public static String expectedExpiredOTPToastMessage = "The OTP you entered has expired. Please request a new OTP to continue.";
	public static String expectedInvalidOTPToastMessage = "The OTP you entered is invalid.";
	public static  String ExpectedSuccessfillActivationOfCustomerNotification = "Account activation successful.";

	//------------------------------------------------------Change Password Page Data --------------------------------//
	public String expectedChangePasswordPageHeader = "Change Password";

	//------------------------------------------------------Review Page Data --------------------------------//
	public String expectedReviewPageHeader = "Review";
	public String expectedEditReviewPageHeader = "Edit Review";

	//------------------------------------------------------Wallet Page Data --------------------------------//
	public static  String expectedCreditTitle = "Credits";
	public static String ExpectedWalletPageHeader = "Wallet";
	public String expectedAddCreditsPopHeader = "Add Credits";
	public String expectedUPIPaymentHeader = "Payment";

	//------------------------------------------------------Verificaiton Page Data --------------------------------//

	public String ExpectedVerificationsPageHeader = "Verifications";
	public String expectedAddVerificationTourText = "Click to add new verification";

	//------------------------------------------------------Add Verificaiton Page Data --------------------------------//
	public String ExpectedAddVerificationsPageHeader = "New Verification";
	public String expectedInstantTourTitle = "Instant Verification";
	public String expectedPhoneTourTitle = "Phone Verification";
	public String expectedEmailTourTitle = "Email Verification";


	//------------------------------------------------------Blogs Page Data --------------------------------//
	public static String expectedBlogsPageHeader = "Blogs";


	//------------------------------------------------------Offline Orders Page Data --------------------------------//
	public String ExpectedOfflineOrdersPageHeader = "Offline Orders";


	/*--------------------------Error validation messages--------------------*/
	public static  String expectedEmptyEmailFieldErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 6);
	public static String expectedInvalidEmailFieldErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 7);
	public static String expectedEmptyPasswordFieldErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 8);
	public static String expectedEmptyConfirmPasswordFieldErrorMsg =notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 11);
	public static String expectedMismatchPasswordAndConfirmPasswordFieldErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 12);
	public static String expectedEmptyPhoneNumberValidationMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 4);
	public static String expectedEmptyOldPasswordValidationMessage	= notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 35);
	public static String expectedEmptyNewPasswordValidationMessage	= notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 36);
	public static String expectedEmptyReviewTitleValidationErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 37);
	public  static String expectedEmptyReviewDescriptionValidationErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 38);
	public static String expectedEmptyUTRNumber= notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 33);
	public static String expectedInvalidPhoneNumberFieldErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 5);
	public static String expectedInvalidInvalidPhoneNumberErrorMsg = notificationDataXL.getCellData(getvalidationMessageExcelSheetName(), getvalidationMessageColName(), 5);;
	
	
	/*--------------------------Notitifications messages --------------------*/
	public static String expectedNotRegisteredEmailIDNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 116);
	public static String expectedSuccessfulResetPasswordNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 117);
	public static String expectedRequestNewLinkWithin5MinNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 117);
	public static String expectedAddUserSuccessNotificationMessage = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 66);
	public static String ExpectedDuplicateEmailIDErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 2);
	public static String ExpectedDuplicatePhoneNumberErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 3);
	public static String ExpectedDuplicateCompanyNameErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 6);
	public static String ExpectedDuplicateCIN_NumberErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 4);
	public static String ExpectedDuplicateGSTIN_NumberErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 5);
	public static String expectedOldPasswordErrorNotification = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 24);
	public static String expectedMaximumAttemptsResetPasswordNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 27);
	public static String ExpectedInvalidProfilePicUploadNotification = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 22);
	public static String ExpectedSuccessFullEditingPersonalNotification = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 19);
	public static String expectedIncorrectOldPasswordNotificationErrorMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 23);
	public static String expectedSuccessFullPasswordChangeNotificationErrorMsg  = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 25);
	public static String expectedIncorrectPasswordNotificationErrorMsg  = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 8);
	public static String expectedTimeDifrenceErrorNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 26);
	public static String expectedPasswordLastThreeErrorNotificationMessage = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 24);
	public static String expectedSuccessReviewNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 28);
	public static String expectedSuccessUpdateReviewNotificationMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 29);
	public static String expectedSuccessOfflineOrderNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 59);
	public static String expectedDuplicateUTRNotifyMsg = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 61);
	public static String expectedSuccessfulGeneratePassswordNotification  = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 123);
	public static String expectedSuccessfullVerificationCreation = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 31);
	public static String expectedAlreadyUsedEmailForVerification=  notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 33);
	public static String expectedAlreadyUsedNumberForVerification= notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 34);
	public static String expectedInsufficientCreditsForVerificationCustomer = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 37);
	public static String expectedOfflineOrdersApproveNotification = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 108);
	public static String expectedUnregisteredNumberForVerification = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 46);

	public static String expectedSuccessfulResetPassswordNotification =  notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 25);
	public static String expectedNewAccountCreationSuccessNotificationMessage = notificationDataXL.getCellData(getnotificationMessageExcelSheetName(), getnotificationMessageColName(), 7);


}
