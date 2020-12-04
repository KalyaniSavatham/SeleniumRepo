package com.infy2;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FileReading {	
    @Test
	public void test() throws Exception {
		//Path from where the excel file has to be read
		String filePath = "C:\\Users\\venkatalakshmikal.s\\git\\SeleniumRepo\\Demo001\\ExcelFile\\Book1.xlsx";
		 
		//File input stream which needs the input as the file location
		FileInputStream fileStream = new FileInputStream(filePath);
				
		//Workbook reference of the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
				
		//Sheet which needs to be accessed from within the workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		 
		//Count the number of rows
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		//Iterating over the rows to get the cell values		
				for (int i = 1; i <= rowCount; i++) {
										
					System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
					System.out.println(sheet.getRow(i).getCell(1).getNumericCellValue());
					System.out.println(sheet.getRow(i).getCell(2).getNumericCellValue());
					System.out.println(sheet.getRow(i).getCell(3).getStringCellValue());
					System.out.println(sheet.getRow(i).getCell(4).getStringCellValue());
					System.out.println(sheet.getRow(i).getCell(5).getStringCellValue());

				}
		//	closing the workbook	
				workbook.close(); //close the workbook
	}	
}
