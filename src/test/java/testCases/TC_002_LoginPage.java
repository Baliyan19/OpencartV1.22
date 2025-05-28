package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginPage extends BaseClass
{
	@Test(groups={"Master","Sanity"})
	void testlogin()
	{	
		try
		{
		logger.info("*****Starting TC_002*********");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lpg=new LoginPage(driver);
		logger.info("************Setting UserInfo***************");
		lpg.SetEmail(p.getProperty("Email"));
		lpg.SetPassword(p.getProperty("Password"));
		lpg.ClickLoginbtn();
		
		//MyAccountPage
		MyAccountPage acpg=new MyAccountPage(driver);
		
		boolean targetPage=acpg.isMyAccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished TC_002*********");
	}
}
	
	
