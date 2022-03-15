package com.crmOrganisationTest;


import java.io.IOException;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelFileUtility;
import com.crm.GenricLibrary.JavaUtility;
import com.crm.GenricLibrary.PropertyFile;
import com.crm.GenricLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.ContactsPage;

import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactWithOrgTest extends BaseClass{
	@Test
	public void ctreateOrgTest() throws IOException{
		
		
		//read the data from excle sheet
      String lastName = elib.readDataFromExcel("Org", 1, 3)+jLib.getRandomNumber();
		
		
		
		
	
		
		//step 4: navigate to contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		
		
		//step 5: create new contacts link/
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContImg();
		
		
		
		//step 6: create contacts with mandatory fields and save
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(lastName);
		
		
	
		
	
	
		
	}
}



