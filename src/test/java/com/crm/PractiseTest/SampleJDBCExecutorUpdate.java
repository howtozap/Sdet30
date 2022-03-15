package com.crm.PractiseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecutorUpdate {
	@Test
	public void sampleJDBCExecutorUpdate() throws SQLException {
		try
		{
			
		//step1:register the database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement state = con.createStatement();
		int Result = state.executeUpdate("insert into student value('4','prashant','male')");
		if(Result==1)
		{
			System.out.println("data addded succesfully");
		}
		else
		{
			System.out.println("data not added");
		}
		}
		catch(Exception e) {
			
		}
		finally
		{
			//steps5:close the database
			con.close();
			System.out.println("connection closed");
		}
		
		
	}

}
