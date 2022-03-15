package com.crm.PractiseTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.GenricLibrary.PropertyFile;

public class PractiseExercise extends PropertyFile {
	@Test
	
	public void practiseExercise() throws Throwable
	{
		PropertyFile pLib = new PropertyFile();
		pLib.readDataFromPropertyFile("browser ");
		pLib.readDataFromPropertyFile("username ");
		pLib.readDataFromPropertyFile("password ");
		
		
		
		
		
		
	}

}
