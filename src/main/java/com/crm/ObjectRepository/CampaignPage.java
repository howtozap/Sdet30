package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	//Declaration
		@FindBy(xpath ="//img[@alt='Create Campaign...']")
		private WebElement createCampaignLookUpImg;
		
		// Initialization
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		// utilization
		public WebElement getCreateCampaignLookUpImg() {
			return createCampaignLookUpImg;
		}

		// business
		public void createCampaignLookUpImg()
		{
			createCampaignLookUpImg.click();
		}
		

}
