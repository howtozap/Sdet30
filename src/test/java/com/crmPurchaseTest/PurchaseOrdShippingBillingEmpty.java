package com.crmPurchaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PurchaseOrdShippingBillingEmpty {
	@Test
	public void purchaseOrdShippingBillingEmpty() throws IOException {
		/*generate random number*/
		 Random ran = new Random();
		int random=ran.nextInt(500);
		
		/*step1: read all necessary data*/
		//read data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property.txt");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROW= pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String UN=pObj.getProperty("username");
		String PWD=pObj.getProperty("password");
		
		//read data from excel sheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		  Workbook wb = WorkbookFactory.create(fi);
		  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Purchase");
		 Row ro = sh.getRow(1);
		  Cell cel = ro.getCell(2);
		String PurName = cel.getStringCellValue();
		Cell ship = ro.getCell(3);
		String shiping = ship.getStringCellValue();
		
		//*step2:launch the browser*/
		WebDriver driver=null;
		if(BROW.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROW.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step3:login to application*/
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//step4:navigate to purchase link
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.name("Purchase Order")).click();
		
		//step5:create purchase order and select billing address
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject"));
		
		//step6:select copy and shipping
		driver.findElement(By.xpath("//input[@onclick='return copyAddressLeft(EditView)']")).click();
		driver.close();
		
		
	}

}
