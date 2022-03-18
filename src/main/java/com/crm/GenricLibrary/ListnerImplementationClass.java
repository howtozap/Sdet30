package com.crm.GenricLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener
{
	ExtentReports reports;
	ExtentTest text;

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"----Test script is started successful",true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"----Test script is pass successful",true);
	}

	public void onTestFailure(ITestResult result) 
	{
		String path=null;
		
		String failTestName=result.getMethod().getMethodName();
		 EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		  File scrFile = eDriver.getScreenshotAs(OutputType.FILE);
		//String Browser = result.getParameters(BROSWER);
		String sdate =new Date().toString().replace(":", "-").replace(" ", "-");
		File  desc=new File("./ScreenShort/"+failTestName+"-"+sdate+".png");
		
		try
		{  
			
			FileUtils.copyFile(scrFile,desc);
		}
		catch(IOException e)
		{
				
		}
	
		  
	
		String MethodName = result.getMethod().getMethodName()+"-";
	String screeshotName = MethodName+new JavaUtility().getSystemDate();
	
	try {
		path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screeshotName);
		
	} catch (IOException e)
	{
		// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	Reporter.log(MethodName+"----Test script is failed",true);
	}

	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"----Test script is skipped",true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
	
	}

	public void onStart(ITestContext context) 
	{
		//Execution will start here
		/*cofigure the report*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDate()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Reort");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
	reports	=new ExtentReports();
	reports.attachReporter(htmlReport);
	reports.setSystemInfo("Base-Browser","Chrome");
	reports.setSystemInfo("Reporter Name", "Prashant");
	}

	public void onFinish(ITestContext context) 
	{
		//consolidate all the parameters and generate the report
		reports.flush();
		
	}

	
}
