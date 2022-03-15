package com.crm.PractiseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class DeleteWebTable extends BaseClass {
	@Test

	public void deletewebtable() {
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		
		WebElement checkbox = driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[2]"));
		checkbox.click();
		WebElement del = driver.findElement(By.xpath("//*[@id=\"row_20\"]/td[10]/a[2]"));
		del.click();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.acceptAlert(driver);
		Reporter.log("delet succesfully,true");
	}
}
