package com.crm.PractiseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.ExcelFileUtility;
import com.crm.GenricLibrary.JavaUtility;
import com.crm.GenricLibrary.PropertyFile;
import com.crm.GenricLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithMultipleDataTest {
	//Create Obj for all utilities
	
		PropertyFile pLib = new PropertyFile();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		@Test
		public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
		{
			
			
			//read data 
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			
			String orgname = orgName+jLib.getRandomNumber();
		
			//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			wLib.maximizeWindow(driver);
			wLib.waitforPageLoad(driver);
			driver.get(URL);
			
			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationlnk();
			Reporter.log("navigated to org link",true);
			
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(orgName, indType);
			Reporter.log("create org with insustry type",true);
			
//			//validate
//			OrganizationPage oip = new OrganizationPage(driver)
//			String actHeader = oip.orgNameInfo();
//			if (actHeader.contains(orgname)) {
//				System.out.println("passed");
//			}
//			else
//			{
//				System.out.println("failed");
//			}
//			Reporter.log("verification successful",true);		
			
			//logout
			hp.signOutOfApp(driver);
			driver.quit();
		}
}
		
//		@DataProvider(name = "OrgtestData")
//		public Object[][] getData() throws Throwable
//		{
//			Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
//			return data;
//
//}
//		}
