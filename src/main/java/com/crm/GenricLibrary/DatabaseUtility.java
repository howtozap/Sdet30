package com.crm.GenricLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains genric method to read data from db
 * @author singh
 *
 */

public class DatabaseUtility {
	
	Connection con=null;
	/**
	 * This method will register the driver
	 * @throws Throwable.
	 */
	public void connectToDb()throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.dbURL,IPathConstant.dbUsername,IPathConstant.dbPassword);
	}

	/**
	 * This method will close database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/**
	 * this method will execute the query and return the matching data to the user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException 
	 * @throws Throwable 
	 */
	public void executeQueryAndGetData(String query,int coulumnIndex,String expData) throws SQLException
	{
		String data =null;
		boolean flag=false;
		ResultSet result= con.createStatement().executeQuery(query);
		
		
	}

}
