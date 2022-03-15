package com.crm.PractiseTest;


import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
		String OrgName = elib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
		//create object of homepage
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		
		//:click on create organisation btn
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		/*Step 6: enter mandatory fields and save*/
		CreateNewContactPage cop=new CreateNewContactPage(driver);
		cop.createNewContact(OrgName);
		
		//varification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.orgNameInfo();
		
		
		
		
		
		
		


}}
