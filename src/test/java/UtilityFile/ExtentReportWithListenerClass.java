package UtilityFile;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.BaseClass;

public class ExtentReportWithListenerClass extends BaseClass implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports createTest;
	ExtentTest createLog;
	
	void setup()
	{
		createReport=new ExtentSparkReporter("MyPracticeProjectReport.html");
		createTest=new ExtentReports();
		createTest.attachReporter(createReport);
		
		createTest.setSystemInfo("OS", "Window");
		createTest.setSystemInfo("Browser", "Chrome");
		createTest.setSystemInfo("version", "124.0.6367.119");
		createTest.setSystemInfo("Environment", "Testing");
		createTest.setSystemInfo("user name", "krishana kant");
		
	
		createReport.config().setDocumentTitle("MyProjectInformation");
		createReport.config().setTheme(Theme.DARK);
		createReport.config().setReportName("facebook-report");
		
		
	}
	public void onStart(ITestContext Result)
	{
		setup();
	}
	public void onFinish(ITestContext Result)
	{
		createTest.flush();
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("OnTestStart");
	}
	public void onTestSuccess(ITestResult Result)
	{
		createLog=createTest.createTest(Result.getName());
		createLog.log(Status.PASS, MarkupHelper.createLabel("TestCase pass", ExtentColor.GREEN));
	}
	public void OnTestFailure(ITestResult Result)
	{
		try {
			ScreenShot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createLog=createTest.createTest(Result.getName());
		createLog.log(Status.FAIL, MarkupHelper.createLabel("TestCase fail", ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult Result)
	{
		createLog=createTest.createTest(Result.getName());
		createLog.log(Status.SKIP, MarkupHelper.createLabel("skip case",ExtentColor.ORANGE ));
	}
	
}
