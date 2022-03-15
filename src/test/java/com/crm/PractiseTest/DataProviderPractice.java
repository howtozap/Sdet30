package com.crm.PractiseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider= "getData")
	
	public void sampleDataProvider(String Name,String model, int qty)
	{
		System.out.println(Name+"---"+model+"----"+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="13 PRO max";
		obj[0][2]=25;
		
		obj[1][0]="iphone";
		obj[1][1]="11max";
		obj[1][2]=12;
		
		obj[2][0]="vivo";
		obj[2][1] ="13 max pro";
		obj[2][2]=30;
		
		obj[3][0]="Samsung";
		obj[3][1]="A80";
		obj[3][2]=12;
		
		return obj;
	}
	
}
