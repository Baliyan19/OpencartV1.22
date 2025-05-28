package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.AccountRegisterationPage;

public class TC_001_AccountRegistrationTest  extends BaseClass
{

	
	
	
	@Test(groups={"Master","Regression"})
	public void verify_account_registration() throws InterruptedException
	{	
		logger.info("*********Starting TC_001_AccountRegistrationTest*********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*********clicked on My account Link*********");

		Thread.sleep(1000);
		hp.clickRegister();
		logger.info("*********clicked on My Register Link*********");

		Thread.sleep(1000);
		
		AccountRegisterationPage rp=new AccountRegisterationPage(driver);
		logger.info("*********Providing customer Details*********");
		rp.SetfirstName(randomeString().toUpperCase());
		rp.SetLastName(randomeString().toUpperCase());
		rp.SetEmail("Rahul"+randomeString()+"@gmail.com");
		rp.SetTelephone(randomNumber());
		
		String pass= Alphanumeric();
		rp.SetPassword(pass);
		rp.SetConfirmPassword(pass);
		rp.SelectAgree();
		rp.continues();
		Thread.sleep(1000);
		logger.info("*********Validating Expected Message*********");
		String confirmationMessage= rp.getConfirmationMsg();
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
	}
		
	catch(Exception e)
	{
		logger.error("Test Failed......");
		logger.debug("Debug Logds....");
		Assert.fail();
	}
		logger.info("*********Finished TC_001_AccountRegistrationTest*********");
}}
