package utils;



import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
public  Object[][] testData(String excelPath, String sheetName) {
	
excelReader exls = new excelReader(excelPath, sheetName);
int rowCount = exls.getRowCount();
int colCount = exls.getColumnCount();
Object data[][] = new Object[rowCount-1][colCount];
for (int i=1;i<rowCount;i++){
for(int j=0;j<colCount;j++){
		String cellData= exls.getCellDataString(i,j);
		System.out.print(cellData + "|");
		data[i-1][j]=cellData;
		}
	System.out.println();
}
return data;

}

@DataProvider(name="loginTestData", parallel=true)
public Object[][] getData()
{
	String excelPath = System.getProperty("user.dir")+"\\testdata\\Data.xlsx";
	
	Object[][] data =testData(excelPath, "Sheet1");
		return data;
	}

/*@DataProvider(name = "commonDataProvider")
public Object[][] getData(Method m)
{
	String excelPath = System.getProperty("user.dir")+"\\testdata\\Data.xlsx";
	
	Object[][] data =null;
	if(m.getName().equals("LoginTest")) {
		data =testData(excelPath, "Sheet1");
	}else if (m.getName().equals("FindAStoreTest")) {
		data =testData(excelPath, "Sheet2");
	}
	return data;

}*/
}
