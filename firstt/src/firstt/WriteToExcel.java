package firstt;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteToExcel {
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	

	public static void setCellData(String path, String sheetName, int rowNum,int colNum, String data) {
		Workbook wb;
		
		try {
			fis = new FileInputStream(path);
			wb=WorkbookFactory.create(fis);		
			//for(int i=0;i<rowNum;i++)
			//{
			wb.getSheet(sheetName).createRow(rowNum).createCell(colNum).setCellValue(data);
			//}			
			fileOut = new FileOutputStream(path);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
		     }   		
		catch (Exception e) 
		    {
			e.printStackTrace();
		    }		
	}
}
