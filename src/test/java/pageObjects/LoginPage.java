package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	 public LoginPage(WebDriver driver)
	 {
		 super(driver);
	 }

	 //Locators
	 @FindBy(xpath="//input[@id='input-email']")
	 WebElement LinkEmail;
	 @FindBy(xpath="//input[@id='input-password']")
	 WebElement LinkPassword;
	 @FindBy(xpath="//input[@value='Login']")
	 WebElement Linkloginbtn;
	
	 
	 //ActionsMethods
	 public void SetEmail(String Email)
	 {
		 LinkEmail.sendKeys(Email);
	 }
	 public void SetPassword(String password)
	 {
		 LinkPassword.sendKeys(password);
	 }
	 public void ClickLoginbtn()
	 {
		 Linkloginbtn.click();
	 }
	 
	
}
