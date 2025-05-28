package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage
{	//Constructor
	public AccountRegisterationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstNameLk;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastNameLk;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailLk;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneLk;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwdLk;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpasswdLk;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeLk;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ContinueLk;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//ActionMethods
	public void SetfirstName(String Fname)
	{
		FirstNameLk.sendKeys(Fname);
	}
	
	public void SetLastName(String Lname)
	{
		LastNameLk.sendKeys(Lname);
	}
	
	public void SetEmail(String Email)
	{
		emailLk.sendKeys(Email);
	}

	public void SetTelephone(String Tele)
	{
		telephoneLk.sendKeys(Tele);
	}
	
	public void SetPassword(String pwd)
	{
		passwdLk.sendKeys(pwd);
	}
	
	public void SetConfirmPassword(String pwd)
	{
		confirmpasswdLk.sendKeys(pwd);
	}
	
	public void SelectAgree()
	{
		agreeLk.click();
	}

	public void continues()
	{
		ContinueLk.click();
		//Sol2.
		//ContinueLk.submit
		//sol3.
		//Actions act= new Actions(driver)
		//act.moveToElement(ContinueLk).click().perform();
		//Sol4.
		//ContinueLk.sendKeys(Keys.Return);
		//Sol5.
		//WebDriver mywait=new WebDriver(driver, Duration.ofSeconds(10));
		//mywait.until(Expectedconditions.elementToBeClickable(ContinueLk)).click();
	}

	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}

