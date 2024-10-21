package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LoginWebElementClass;
import UtilityFile.DataDrivenTestingClass;

//   public class TestCaseClass extends  BaseClass 
//  {
//	@Test
//	void openurl()
//	{ 
	//	driver.get(url);             // simple  automate the test case with generate the log
	//	LoginWebElementClass lw=new LoginWebElementClass(driver);
	//	lw.user_email("kkant1988@gmail.com");
	//	lw.user_password("6200879547");
	//	lw.user_login();
	//	lw.user_clickerrorbox();
	//	log1.info(" click on errorbox");
	//	lw.user_secureaccount();
	//	log1.info(" click on secureaccount");
	//	log1.info(" entercurrentpassword");
	
		
//automate the test case with generate the extent report
	//	public class TestCaseClass extends  BaseClass 
	//	{
	//		@Test
	//		void openurl()
	//	driver.get(url);            
	//	log1.info("open url");
	//	LoginWebElementClass lw=new LoginWebElementClass(driver);
	//	lw.user_email("kkant1988@gmail.com");
	//	log1.info(" Enter the emailid");
	//	lw.user_password("6200879547");
	//	log1.info(" Enter the user password");
	//	lw.user_login();
	//	log1.info(" Click on login button");
	//	lw.user_clickerrorbox();
	//	log1.info(" click on errorbox");
	//	lw.user_secureaccount();
	//	log1.info(" click on secureaccount");
	//	lw.user_entercurrentpassword();
	//	log1.info(" entercurrentpassword");
		
//automate the test case by data driven testing

		public class TestCaseClass extends  BaseClass 
		{
			@Test(dataProvider="DataPro")
			
		void openurl(String emailid,String passwrd)
		{
		driver.get(url);            
		log1.info("open url");
		LoginWebElementClass lw=new LoginWebElementClass(driver);
		lw.user_email("emailid");
		log1.info(" Enter the emailid");
		lw.user_password("passwrd");
		log1.info(" Enter the user password");
		lw.user_login();
		log1.info(" Click on login button");
		lw.user_clickerrorbox();
		log1.info(" click on errorbox");
		lw.user_secureaccount();
		log1.info(" click on secureaccount");
		lw.user_entercurrentpassword();
		log1.info(" entercurrentpassword");
		
			}
	@DataProvider(name="DataPro")
	public String [][] searchData() throws Exception 
	{
		String filename="C:\\Users\\abhay\\OneDrive\\Desktop\\Book2.xlsx";
		int row=DataDrivenTestingClass.getRow(filename, "Sheet1");
		int col=DataDrivenTestingClass.getCol(filename, "Sheet1");
		String s1[][]=new String [row-1][col];
		for(int i=1; i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				s1[i-1][j]=DataDrivenTestingClass.getCellValue(filename,"sheet1",i,j);
			}
		}
       return s1;
}
	}
		
