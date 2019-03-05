package firstt;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadFromExcel
{
	public static String readExcel(String path, String sheet, int row, int cell)
	{
		String v="";
		try
		{
			
			FileInputStream fis=new FileInputStream(path);			
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			Row r1=sh.getRow(row);
			Cell c=r1.getCell(cell);
			System.out.println(c);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("path is invalid");
		}
		return v;
		
}
	public static String readExcel(String path, String sheet, String rowName, String cellName)
	{
		String v="";
		try
		{
			FileInputStream fis=new FileInputStream(path);
			
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int rowno=-1;
			int colno=-1;
			
			for(int i=0;i<sh.getLastRowNum();i++)
			{
				if(sh.getRow(i).getCell(0).getStringCellValue().equals(rowName))
				{ 					
					rowno=i;
				for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
				{					
					if(sh.getRow(i-1).getCell(j).getStringCellValue().equals(cellName))
					{						
						colno=j;					 			 
					    break;
					}
				}
				}
			}
			System.out.println(sh.getRow(rowno).getCell(colno).getStringCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("path is invalid");
		}
		return v;		
}
	
	public static void main(String[] args)
	{
		System.out.println("Using rowNum and cellNum");
		readExcel("C:\\Users\\AmishOm\\git\\demo1.1\\firstt\\Excel\\Book1.xlsx","Sheet1",1,1);	
		System.out.println("Using rowName and cellName");
		readExcel("C:\\Users\\AmishOm\\git\\demo1.1\\firstt\\Excel\\Book1.xlsx","Sheet1","Amish","Hindi");
	}
}
