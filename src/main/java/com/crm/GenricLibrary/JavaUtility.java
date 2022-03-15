package com.crm.GenricLibrary;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate a random number and return it to user
	 * @return
	 */
public int getRandomNumber()
{
	Random ran= new Random();
	int random=ran.nextInt(500);
	return random; 
	
}
/**
 * This method will generate current system date and return it usrer
 * @return
 */
public String getSystemDate()
{
	Date d=new Date();
	String date=d.toString();
	return date;
}
/**
 * This method will genrate system date and return date in format
 * @return
 */
public String getSystemDateInFormat()
{
	Date d=new Date();
	String d1=d.toString();
	String[] date=d1.split(" ");
	
	String mon= date[1];
	String day= date[2];
	String time = date[3].replace(":", "-");
	String year=date[5];
	 
	
	String DateFormat= day+"_"+mon+" "+year+"-"+time;
	return DateFormat;
	
	
}

 
}
