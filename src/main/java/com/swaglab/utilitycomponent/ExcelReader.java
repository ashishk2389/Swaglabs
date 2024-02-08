package com.swaglab.utilitycomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class ExcelReader {
	

	public static void main(String[] args) throws IOException {
		
		String test[][] = getLoginCredenatils("Sheet1");	
		
		
		for(int i =0;i<test.length;i++)
		{
			
			for(int j =0;j<test[0].length;j++)
			{
				System.out.print(test[i][j]+" ");
			}
			System.out.println("");
		}
		
		
	}
	
	
	public static String[][] getLoginCredenatils(String sheetName) throws IOException 
	{

		   File file = new File("user.dir" + "/src/main/resources/Elements.xlsx");
	         FileInputStream fIP = new FileInputStream(file);
		
			//	new XSSFWorkbook(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fIP);		
		Sheet sheet = 	  workbook.getSheet(sheetName);
		//test array 
				String credentials[][] = new String[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];

		
		Iterator<Row> rowIterator = sheet.iterator();
		int rowNum=0;
		while (rowIterator.hasNext()) {	
			int col = 0 ;
		    Row row = rowIterator.next();
		    Iterator<Cell> cellIterator = row.iterator();
		    while (cellIterator.hasNext()) {
		        Cell cell = cellIterator.next();
		        // Process the cell value
		        DataFormatter dataFormatter = new DataFormatter();
		        String str = dataFormatter.formatCellValue(cell);
//		        System.out.print(str+" ");
		        credentials[rowNum][col] = str;
		        col++;
		    }
//	        System.out.println(" ");

		   
		    
		    rowNum++;
		
		}
		
		workbook.close();
//		file.close();
		
		return credentials;

	}

}
