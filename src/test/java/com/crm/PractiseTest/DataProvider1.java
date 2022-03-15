package com.crm.PractiseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
@Test(dataProvider= "getData")
	
	public void sampleDataProvider(String Name,String model)
	{
		System.out.println(Name+"---"+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[6][2];
		
		obj[0][0]="Mi";
		obj[0][1]="13 PRO max";
		
		
		obj[1][0]="iphone";
		obj[1][1]="11max";
		
		
		obj[2][0]="vivo";
		obj[2][1] ="13 max pro";
		
		
		obj[3][0]="Samsung";
		obj[3][1]="A80";
		
            obj[4][0]="Nokia";
            obj[4][1]="E15";
         
            obj[5][0]="poco";
            obj[5][1]="m2pro";
		
		return obj;

}
	}
