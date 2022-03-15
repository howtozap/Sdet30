package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampaignPage {
	
	//Declaration
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	//initialization
	@FindBy(xpath = "//input[@value='U']")
	private WebElement userRadioOPtion;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioOption;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//utilization

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getUserRadioOPtion() {
		return userRadioOPtion;
	}

	public WebElement getGroupRadioOption() {
		return groupRadioOption;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//bussiness library
	public void campaignName()
	{
		campaignName.sendKeys("Campaign");
		userRadioOPtion.click();
		saveBtn.click();
	}
}
