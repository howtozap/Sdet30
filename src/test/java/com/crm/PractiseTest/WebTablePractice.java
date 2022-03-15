package com.crm.PractiseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTablePractice  extends BaseClass{

	@Test
	public void webTablePractice()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();
		
		List<WebElement> chekbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		int count = chekbox.size();
		for(WebElement box:chekbox)
		{
			box.click();
			Reporter.log("all check box selectred",true);
		}
		
	}
}
