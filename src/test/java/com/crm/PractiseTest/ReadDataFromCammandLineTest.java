package com.crm.PractiseTest;

import org.testng.annotations.Test;

public class ReadDataFromCammandLineTest {
	@Test
	
	public void readDataFromCmdLine()
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println("browser name is"+BROWSER);
		System.out.println("URL is"+URL);
		System.out.println("username"+USERNAME);
		System.out.println("password is"+PASSWORD);
		
		
	}

}
