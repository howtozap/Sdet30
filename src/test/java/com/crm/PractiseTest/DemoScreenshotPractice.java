package com.crm.PractiseTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenricLibrary.ListnerImplementationClass.class)
public class DemoScreenshotPractice extends BaseClass {
	@Test
	public void createcontactwithorgTest() throws EncryptedDocumentException, IOException 
	{
		
	
		
		//read the data from excle sheet
	      String lastName = elib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		
			
			/*step4: navigate to contact link*/
			HomePage hp=new HomePage(driver);
			hp.clickOnContactLnk();
			
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContImg();
			
		
			
			/*step6: create contact with mandatory fields*/
			CreateNewContactPage ccp=new CreateNewContactPage(driver);
			ccp.createNewContact(lastName);
			
	Assert.fail();


	}

}
