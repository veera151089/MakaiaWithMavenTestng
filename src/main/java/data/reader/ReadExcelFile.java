package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile {

	@Test
	public Object[][] readExcel(String fileName) throws IOException
	{
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+ fileName +".xlsx");
		XSSFSheet sheet = wBook.getSheetAt(0);
		int rowCnt = sheet.getLastRowNum();
		int colCnt = sheet.getRow(0).getLastCellNum();
		Object[][] retData = new Object[rowCnt][colCnt];
		for (int i=1; i<=rowCnt; i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			for (int j=0; j<colCnt; j++)
			{
				XSSFCell currentCell = currentRow.getCell(j);
				String cellValue = currentCell.getStringCellValue();
				System.out.println(cellValue);
				retData[i-1][j] = cellValue;
			}
		}
//		wBook.close();
		return retData;
	}
}
