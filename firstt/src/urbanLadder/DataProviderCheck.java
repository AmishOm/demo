package urbanLadder;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCheck 
{
	
	@DataProvider
	public static Object[][] actual()
	{
		Object[][] arr=new Object[10][2];
		try
		{			
			FileInputStream fis=new FileInputStream("C:\\Users\\AmishOm\\git\\demo1.1\\firstt\\Excel\\UrbanLadder0603.xlsx");			
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");			
			
			for(int i=1;i<=sh.getLastRowNum();i++)
			{
				
				for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
				{				
					arr[i-1][j] = sh.getRow(i).getCell(j).toString();	
					//System.out.println(arr[i][j]);
				}
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("path is invalid");
		}
		return arr;	
}	
	@Test(dataProvider="actual")
	public  void GetCellData( String actual, String expected)
	{
		Assert.assertEquals(actual, expected);	
				
	}	
	@AfterMethod
	public void  testResult(ITestResult result)
	{
		if(result.getStatus()==1)
		{
			System.out.println("passed");
		}
		else if (result.getStatus()==2)
		{
			System.out.println("failed");
		}	
	}
}
