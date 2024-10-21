package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebElementClass  
{
	WebDriver CurrentDriver ;
	public LoginWebElementClass(WebDriver RemoteDriver)
	{
		CurrentDriver=RemoteDriver;
		PageFactory.initElements( RemoteDriver ,this);
	}
	@FindBy(id="email") WebElement emailid ;
	@FindBy(id="pass") WebElement  Password;
	@FindBy(name="login") WebElement login;
	@FindBy(xpath="//a[text()='click here']") WebElement errorbox;
	@FindBy(xpath="//a[text()='Secure My Account']") WebElement secureaccount;
	@FindBy(xpath="//input[@type='password']") WebElement entercurrentpassword;
	
	public void user_email(String number)
	{
		emailid.sendKeys(number);	
	}
	public void user_password(String pass)
	{
		Password.sendKeys(pass);
	}
	public void user_login( )
	{
		login.click();
	}
	public void user_clickerrorbox()
	{
		errorbox.click();	
	}
	public void user_secureaccount()
	{
		secureaccount.click();
	}
	public void user_entercurrentpassword()
	{
		entercurrentpassword.click();
	}
	
		
}
