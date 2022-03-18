
package com.crm.GenricLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This class consist of all genric methods related to webDriverActions
	 * @author singh
	 */
		
	/**
	 * This method will maximize window
	 * @param driver
	 */
	
	/**
	 * wait for page to load before indentifying any sychronized element in DOM [HTML-Docuent]
	 * @param driver
	 */
	/**
	 * This method will maximize window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitforPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait for 10 seconds for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will select the data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will select the data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will select the data from the dropdown using value
	 * @param text
	 * @param element
	 */
	public void select(String value,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will perform mouse Hover action
	 * @param driver
	 * @param element
	 */
	public void selectMouseHouer(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element);
	}
	
	/**
	 * This method will double click on Webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will right click on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will press enter Key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will press enter Key
	 * @throws Throwable
	 */
	
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch the frame based on name or ID
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * This method wil cancel the alert popup
	 * @param driver 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * 
	 * @param driver
	 */
	public void switchToWindows(WebDriver driver, String partialWinTitele)
	{
		Set<String> windows= driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String winid= it.next();
			String currentWinTitle=driver.switchTo().window(winid).getTitle();
			if(currentWinTitle.contains(partialWinTitele))
			{
				break;
			}
			
		}
	}
		public String getScreenShot(WebDriver driver,String screenShotName) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File("./screenshot/"+screenShotName+".PNG");
	    	Files.copy(src, dest);
	    	  String path = dest.getAbsolutePath();
	    	  return path;
		
	}
		public void scrollAction(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
		}
		public void scrollAction(WebDriver driver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			int y=element.getLocation().getY();
			js.executeAsyncScript("window.scrollby(0,"+y+",)", element);
		}

		public void switchToWindow(WebDriver driver, String string) {
			// TODO Auto-generated method stub
			
		}
		
	
	
}
