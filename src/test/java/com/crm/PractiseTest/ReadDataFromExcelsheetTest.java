package com.crm.PractiseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelsheetTest {
	@Test
	public void writeDataIntoExcelSheet() throws EncryptedDocumentException, IOException
	{
		//open file in read mode
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		//craete workbook factory
		 Workbook wb = WorkbookFactory.create(fis);
		 //step3:get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(0);
		//create a cell to write new data
		Cell ce = ro.createCell(2);
		//open file in write mode
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Book1.xlsx");
		wb.write(fos);
	}

}
