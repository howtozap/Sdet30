package com.crmCampaignTest;



import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelFileUtility;
import com.crm.GenricLibrary.JavaUtility;
import com.crm.GenricLibrary.PropertyFile;
import com.crm.GenricLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

@Listeners(com.crm.GenricLibrary.ListnerImplementationClass.class)
public class CreateConatctWithOrgTest extends BaseClass
{

		@Test(retryAnalyzer = com.crm.GenricLibrary.RetryAnaliserImplementation.class)
		public void createcontactwithorgTest() throws EncryptedDocumentException, IOException 
		{
			
		
			
			//read the data from excel sheet
		      String lastName = elib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
			
				
				/*step4: navigate to contact link*/
				HomePage hp=new HomePage(driver);
				hp.clickOnContactLnk();
				
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContImg();
				Assert.fail();
				
			
				
				/*step6: create contact with mandatory fields*/
				CreateNewContactPage ccp=new CreateNewContactPage(driver);
				ccp.createNewContact(lastName);
				
			


		}
}
