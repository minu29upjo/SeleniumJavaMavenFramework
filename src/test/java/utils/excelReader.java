package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	static String projectPath;
	static XSSFWorkbook wbk;
	static XSSFSheet sheet;


	public static void main(String[] args) {

	}

	public excelReader(String excelPath, String sheetName)
	{
		try {	

			wbk = new XSSFWorkbook(excelPath);
			sheet = wbk.getSheet(sheetName);

		}catch (Exception exp) {
			exp.getMessage();
			exp.getCause();			
			exp.printStackTrace();
		}
	}


	public static int getRowCount()
	{
		int rowCount=0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("The total number of rows are:" +rowCount);
		}catch (Exception exp) {
			exp.getMessage();
			exp.getCause();			
			exp.printStackTrace();
		}
		
		return rowCount ;
	}


	public static int getColumnCount()
	{
		int colCount=0;
		try {
			colCount = sheet.getRow(0).getLastCellNum();
			//System.out.println("The total number of columns are:" +colCount);
		}catch (Exception exp) {
			exp.getMessage();
			exp.getCause();			
			exp.printStackTrace();
		}
		return colCount ;
	}

	public static String getCellDataString(int rowNum, int colNum)
	{
		String cellData = null;
		try {
			cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("The string cell value is:"+cellData);
		}catch(Exception exp) {
			exp.getMessage();
			exp.getCause();			
			exp.printStackTrace();	
		}
		return cellData;
	}


	public static double getCellDataNumeric(int rowNum, int colNum)
	{
		double cellData = 0;
		try {
			cellData =sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("The numeric cell value is:"+cellData);
		}catch(Exception exp) {
			exp.getMessage();
			exp.getCause();			
			exp.printStackTrace();	
		}
		return cellData;
	}

}