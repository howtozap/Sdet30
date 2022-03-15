package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	
	//step 1 declaration

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
		private WebElement homeIconImg;
		
		//step 2 initialization
		public  OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step 3: utilization
		
		public WebElement getHeaderText() {
			return headerText;
		}
		
		public WebElement getHomeIconImg() {
			return homeIconImg;
		}

		public String orgNameInfo()
		{
			String orgInfo = headerText.getText();
			return orgInfo;
			
		}

		// business
		public void OrganizationInfoPage()
		{
			String actHeader = headerText.getText();
			System.out.println(actHeader);
			homeIconImg.click();
		}

}
