package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	 
	XSSFWorkbook wb;
	public ExcelDataProvider() throws FileNotFoundException
	{
		File src = new File("./TestData/Data.xlsx");
	
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			System.out.println("unable to read excel file"+e.getMessage());
			
		}
		
	}
	
	public String getStringdata(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	

}
