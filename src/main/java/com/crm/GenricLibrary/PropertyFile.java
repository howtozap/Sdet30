package com.crm.GenricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	/*
	 * this
	 */
public String readDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pLib=new Properties();
	pLib.load(fis);
	String value=pLib.getProperty(key);
	return value;
}

}
