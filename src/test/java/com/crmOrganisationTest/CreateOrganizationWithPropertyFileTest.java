package com.crmOrganisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelFileUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithPropertyFileTest extends BaseClass {
	private static final String Org = null;

	@Test
	
	public void CreateOrgTest() throws IOException, InterruptedException 
	{
		//steps1:read data from property file
		ExcelFileUtility eLib = new ExcelFileUtility();
		eLib.readDataFromExcel("Org", 1, 2);
		
	
		//Step3:navigate to origanizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationlnk();
		
		//Step4: click on create Organization
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrgImg();
	
	
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(Org);
		
		
		
		
			
	}

}
