package com.crm.PractiseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerification {
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		String actualdata="prashant";
		Connection con=null;
			//step:register the database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			//step2:get connection from database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
			System.out.println("connection stablished");
			//step 3issue create statement
              Statement state = con.createStatement();
              
              //step 4:execute a query
               ResultSet result = state.executeQuery("select * from student;");
               while(result.next())
               {
            	  // System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getShort(3));
            	   String expecteddata = result.getString(1);
            	   if(expecteddata.equalsIgnoreCase(actualdata))
            	   {
            		   System.out.println(actualdata+" Data verified");
            	   }
               }
              
		}
	}


