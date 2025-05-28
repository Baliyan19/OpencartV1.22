package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	//Locators
	 @FindBy(xpath="//h2[normalize-space()='My Account']")
	 WebElement getconfimtext;
	 
	 @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	 WebElement Logoutbtn;
	 
	 
	 //ActionsMethoda
	 //----------------------This will cause problem don't use this --------------------------------------
	/* public String GetConfirmation()
	 {
		 try 
		 {
			return getconfimtext.getText();
		 }
		 catch(Exception e)
		 {
			 return(e.getMessage());
		 }
	 }*///---------------------------------------------------------------------------------------------------
	 
	 public boolean isMyAccountPageExists()
	 {
		 try
		 {
			 return(getconfimtext.isDisplayed());
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
	 
	 public void logout()
	 {
		 Logoutbtn.click();
	 }
}
