package com.crm.GenricLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//Create object of all utilities
	public DatabaseUtility dbLib=new DatabaseUtility();
	public ExcelFileUtility elib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public PropertyFile pLib=new PropertyFile();
    public WebDriverUtility	wLib=new WebDriverUtility();
    public WebDriver driver;
    
    public static WebDriver sDriver;
    
    @BeforeSuite(groups={"smokesuite","regression"})
    public void connectDataBase() throws Throwable
    {
    	//dbLib.connectTodb
    	Reporter.log("======db connection succesful===",true);
    }
   // @Parameters("browser")
   // @BeforeTest
    @BeforeClass(groups= {"smoke","regression"})
    public void launchTHeBrowser() throws Throwable
    {
    	//read the dat data from property file
    	String BROWSER=pLib.readDataFromPropertyFile("browser");
    	String URL=pLib.readDataFromPropertyFile("url");
    	
    	//craete run time polymorphism
    	if(BROWSER.equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();	
    	}
    	else if(BROWSER.equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    	}
    	
    	else
    	{
    		System.out.println("invalid browser");
    	}
    	
    	sDriver = driver;
    	wLib.maximizeWindow(driver);
    	wLib.waitforPageLoad(driver);
    	driver.get(URL);
    	Reporter.log("======browser launch successfully",true);
    }
    @BeforeMethod(groups= {"smoke","regression"})
    public void login() throws Throwable
    {
    	String USERNAME=pLib.readDataFromPropertyFile("username");
    	String PASSWORD=pLib.readDataFromPropertyFile("password");
    	LoginPage lp=new LoginPage(driver);
    	lp.LoginToApp(USERNAME, PASSWORD);
    	Reporter.log("======login succefull===",true);
    	
    }
    @AfterMethod(groups= {"smoke","regression"})
    public void logout() throws Throwable
    {
    	HomePage hp=new HomePage(driver);
    	hp.signOutOfApp(driver);
    	Reporter.log("====logout succesFull====",true);	
    }
    @AfterClass(groups= {"smoke","regression"})
    public void closeBrowser()
    {
    	driver.quit();
    	Reporter.log("====successfull closed the browser===",true);
    }
    @AfterSuite(groups= {"smoke","regression"})
    public void closeDb()
    {
    	//dbLib.closedb()
    	Reporter.log("====Database close succesful==",true);    	
    }
    
}
