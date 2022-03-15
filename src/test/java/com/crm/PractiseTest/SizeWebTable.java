package com.crm.PractiseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class SizeWebTable extends BaseClass{
	@Test

	public void sizewebtable() {
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLnk();
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int Count = checkbox.size();
		for(WebElement box:checkbox)
		{
			box.click();
			Reporter.log("count of selected option",true);
		}
				

}}
