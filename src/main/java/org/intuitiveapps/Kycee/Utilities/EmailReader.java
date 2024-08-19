package org.intuitiveapps.Kycee.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageListParams;
import com.mailosaur.models.MessageListResult;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class EmailReader {
	public  String getServerId() {
		Properties prop =new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return prop.getProperty("ServerID");
	}
	
	public String getServerDomain() {
		Properties prop =new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("ServerDomain");
	}
	
	public  String getMailosaurAPIKey() {
		Properties prop =new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\intuitiveapps\\Kycee\\Resources\\GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("MailosaurAPIKey");
	}
	
	
	public Message wiatForEmail(String mailId,MailosaurClient mailsour,String subject) {
		Wait<MailosaurClient> wait = new FluentWait<>(mailsour)
				.withTimeout(Duration.ofSeconds(360))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);

		return wait.until(mailsaurClient -> {
			try {
				MessageSearchParams params = new MessageSearchParams();
				params.withServer(getServerId());
				SearchCriteria criteria = new SearchCriteria();
				criteria.withSentTo(mailId);
				criteria.withSubject(subject);

				Message message = mailsaurClient.messages().get(params, criteria);
				return message;
			} catch (Exception e) {
				return null;
			}	

		});
	}




	public String  getotpFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Account Activation via OTP");
		String messageID = message.id();
		deleteEmailWithId(messageID);
		Code otp = message.html().codes().get(0);
		return otp.value();
	}
	
	public String  getExpiredEditEmailOTPFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Email Verification via OTP");
		String messageID = message.id();
		deleteEmailWithId(messageID);
		Code otp = message.html().codes().get(0);
		return otp.value();
	}
	
	public String  getEditEmailOTPFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Email Verification via OTP");
		String messageID = message.id();
		deleteEmailWithId(messageID);
		Code otp = message.html().codes().get(0);
		return otp.value();
	}
	
	public String  getGeneratePasswordLinkFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Generate Password");
		String messageID = message.id();
	//	deleteEmailWithId(messageID);
		System.out.println( message.html().links().get(1));
		Link otp =  message.html().links().get(1);
		return otp.href();
	}
	
	public String  getExpiredResetPasswordLinkFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Reset Password");
		String messageID = message.id();
		deleteEmailWithId(messageID);
		Link otp =  message.html().links().get(1);
		return otp.href();
	}
	
	public String  getResetPasswordLinkFromEmail(String email) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur,"KYCEE: Reset Password");
		String messageID = message.id();
		Link otp =  message.html().links().get(1);
		return otp.href();
	}

	public void deleteEmailWithId(String id) throws MailosaurException, IOException {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		MessageListParams params = new MessageListParams();
		params.withServer(getServerId());
		MessageListResult result = mailosaur.messages().list(params);
		Message message1 = mailosaur.messages().getById(id);
		mailosaur.messages().delete(id);
		String subject = message1.subject();
		System.out.println("Mail with "+ subject +"And ID " + id +" is Deleted");
		
	}
	public String  getotpFromEmailUsingID(String email) throws MailosaurException, IOException  {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur, "KYCEE: Account Activation via OTP");
		String messageID = message.id();
		deleteEmailWithId(messageID);
		Code otp = message.html().codes().get(0);
		System.out.println(otp.value());
		//		try {
		//			mailosaur.messages().deleteAll(getServerId());
		//		} catch (MailosaurException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		return otp.value();
	}

	public String  getExpiredotpFromEmailUsingID(String email)  {
		MailosaurClient mailosaur = new MailosaurClient(getMailosaurAPIKey());
		Message message = wiatForEmail(email, mailosaur, email);

		Code otp = message.html().codes().get(0);
		try {
			mailosaur.messages().deleteAll(getServerId());
		} catch (MailosaurException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return otp.value();
	}
}
