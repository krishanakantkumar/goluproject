package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import UtilityFile.ReadConfigurationClass;

public class BaseClass 
{
	public static WebDriver driver;
	public static Logger log1;
	ReadConfigurationClass rc= new ReadConfigurationClass();
	String url=rc.geturl();
	String browser=rc.getbrowser();
	@BeforeClass
	void browserLaunch()
	{
		switch(browser.toLowerCase())
		{
		
		case"chrome":
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;
		
		case"msedge":
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		break;
		
		case"firefox":
		 driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		
		default:
		driver=null;
		break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log1=LogManager.getLogger("DDFWP1");
		
	}	
      public void ScreenShot() throws Exception
      {
    	  TakesScreenshot sc= (TakesScreenshot)driver;
    	  File f1=sc.getScreenshotAs(OutputType.FILE);
    	  File f2=new File("C:\\Users\\abhay\\eclipse-workspace\\DDFWP1\\ScreenShots\\DDFWP1.png");
    	  FileUtils.copyFile(f1, f2);
      }
}
