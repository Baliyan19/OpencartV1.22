package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j


public class BaseClass {
public static WebDriver driver;

public Logger logger;//Log4j
public Properties p;
	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters({"OS","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException
	{	
		ConfigReader configReader = new ConfigReader();
        p = configReader.getProperties(); // Load configuration properties
		logger=LogManager.getLogger(this.getClass()); 
		
		if (p.getProperty("execution_environment").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
			cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("Mac"))
			{
			cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
				System.out.println("No Matching OS");
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			case "firefox":cap.setBrowserName("firefix");break;
			default: System.out.println("No Matching browser"); return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		if(p.getProperty("execution_environment").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver= new FirefoxDriver();break;
		default : System.out.println("Invalid browsername..");return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Loading properties file to get URL
		FileReader file =new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		driver.get(p.getProperty("URL"));//Reading URL from properties file
		//
		Thread.sleep(2000);
	}
	
	@AfterClass(groups= {"Regression","Sanity","Master"})
	public void teardown()
	{
		driver.close();
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String numbergenerated= RandomStringUtils.randomNumeric(10);
		return numbergenerated;
	}
	
	public String Alphanumeric()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(3);
		String numbergenerated= RandomStringUtils.randomNumeric(3);
		return (generatedString+"#"+numbergenerated);
	}
	
	public String captureScreen(String tname)
	{
		String timeStampt= new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourcefile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStampt+".png";
		File targetFile=new File(targetFilePath);
		
		sourcefile.renameTo(targetFile);
		
		return targetFilePath;
		
	}
	
}
