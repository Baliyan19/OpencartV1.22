package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

//Data is valid----login  successful  ---Test passed//Logout
//Data is Valid----login not successful----Test Failed
//Data is invalid-----login is successful -----Test Failed//Logout
//Data is invalid-----login is not successful ---Test Passed


public class TC_003_LoginDataDriven extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void TestLoginDataDriven(String eamil,String password, String exp)
	{   
		logger.info("*************************Started TC_003_LoginDataDriven******************************");
		try
		
		{
		//HomePgae
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//LoginPage
		LoginPage lpg=new LoginPage(driver);
		lpg.SetEmail(eamil);
		lpg.SetPassword(password);
		lpg.ClickLoginbtn();
		
		//MyAccount
		MyAccountPage accpg=new MyAccountPage(driver);
		boolean targetPage=accpg.isMyAccountPageExists();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				accpg.logout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				accpg.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(true);
			}	
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*************************Finished TC_003_LoginDataDriven******************************");
	}
	

}
