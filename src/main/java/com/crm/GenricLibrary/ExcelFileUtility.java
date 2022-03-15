package com.crm.GenricLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * this method will read data from excel sheet and return the value the value when sheet name 
	 * row no and cell number is specified
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 * */
	public String readDataFromExcel(String SheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(celNo);
		String value=cel.getStringCellValue();
		return value;
		
	}
	/**
	 * This method will write data into excel shett
	 * @param SheetName
	 * @param rowno
	 * @param celNo
	 * @param value
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName, int rowno,int cellNo,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(rowno);
		Cell cel = ro.createCell(cellNo);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);
		
	}
		/**
		 * This method will return last row number
		 * @param SheetName
		 * SheetName
		 * @return 
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		 * @throws Throwable
		 * @throws Throwable
		 */
		public int getRowCount(String SheetName1) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(IPathConstant. ExcelPath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName1);
			int row=sh.getLastRowNum();
			return row;
		}
			
		/**
		 * This method will read multiple data from excel sheet with the help of sheetname
		 * and return 2 dimensional object [][]
		 * @param SheetName
		 * @return
		 * @throws Throwable
		 */
		public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
		{
			FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			int lastRow = sh.getLastRowNum();
			int lastCell = sh.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[lastRow][lastCell];
			
			for(int i = 0;i<lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			return data;
		
		}
		
	}
