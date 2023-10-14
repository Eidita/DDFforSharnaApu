package com.facebook.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String filePath;
	public String sheetName;
	
	public ExcelReader(String filePath, String sheetName) {
		super();
		this.filePath = filePath;
		this.sheetName = sheetName;
	}
	public String getStringCellValue(int rowNum, int columnNum) {
		String cellData=null;
		try {
			FileInputStream fis=new FileInputStream(filePath);
		//fis= refferencial object
			//only file path will read
			
			Workbook registrationBook=new XSSFWorkbook(fis);
		Sheet sheet=registrationBook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell column=row.getCell(columnNum);
		cellData=column.getStringCellValue();
		System.out.println(cellData);
		registrationBook.close();
		fis.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return cellData;
	}
	
	public double getNumericCellValue(int rowNum, int columnNum) {
		double cellData=0.0;
		try {
			FileInputStream fis=new FileInputStream(filePath);
			try (Workbook registrationBook = new XSSFWorkbook(fis)) {
				Sheet sheet=registrationBook.getSheet(sheetName);
				Row row=sheet.getRow(rowNum);
				Cell column=row.getCell(columnNum);
				cellData=column.getNumericCellValue();
			}
			System.out.println(cellData);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return cellData;
		
	}
	public static void main(String[] args) {
		String file="src/test/resources/registration.xlsx";
		ExcelReader er=new ExcelReader(file, "Sheet1");
		er.getStringCellValue(0, 0);
		
		ExcelReader er1=new ExcelReader(file, "Sheet3");
		er1.getNumericCellValue(0, 0);
	}

}
