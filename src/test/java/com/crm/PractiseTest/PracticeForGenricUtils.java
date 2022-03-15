package com.crm.PractiseTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.GenricLibrary.JavaUtility;
import com.crm.GenricLibrary.PropertyFile;

public class PracticeForGenricUtils {
	
	@Test
	public void practice() throws IOException {
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandomNumber();
		String dat = jLib.getSystemDateInFormat();
		String date = jLib.getSystemDate();


		
		PropertyFile pLib = new PropertyFile();
		String brow = pLib.readDataFromPropertyFile("browser");
		System.out.println(brow);
	}

}
