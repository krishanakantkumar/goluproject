package UtilityFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigurationClass
{
Properties pro;
  String path="C:\\Users\\abhay\\eclipse-workspace\\DDFWP1\\Configuration\\Config.properties";
  public ReadConfigurationClass() 
  {
	  FileInputStream fn=null;
	  pro=new Properties();
	  try {
		  
		 fn=new  FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		pro.load(fn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public String geturl()
  {
	String url=  pro.getProperty("baseurl");
	if(url!=null)
	{
		return url;
	}
	else
	{
		throw new RuntimeException("url not found");
	}
  }
  public String getbrowser()
  {
	String browser= pro.getProperty("browser");
	if(browser!=null)
	{
		return browser;
	}
	else
	{
		throw new RuntimeException("browser not found");
	}
	  
	  
  }
}
