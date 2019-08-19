package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;

public class JavaOnlyMethods {
	public static DataFormatter formatter = new DataFormatter();
//	
//	public static void main(String[] args) {
//		JavaOnlyMethods j = new JavaOnlyMethods();
//		System.out.println(j.getAlphaNumericString(5));
//	}

	public List<String> getEntirevalue(String fileName, String sheetName) throws IOException {
		FileInputStream fs = new FileInputStream(fileName);
		Workbook wb = new HSSFWorkbook(fs);
		Sheet sh = wb.getSheet(sheetName);
		HSSFRow Row = (HSSFRow) sh.getRow(0);
		List<String> list = new ArrayList<String>();
		int RowNum = sh.getPhysicalNumberOfRows();
		int ColNum = Row.getLastCellNum();
		Object Data[][] = new Object[RowNum - 1][ColNum];
		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			HSSFRow row = (HSSFRow) sh.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					HSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
						// System.out.println("Value:" + value);
						list.add(value);
					}
				}
			}
		}
		return list;
	}

	public String getAlphaNumericString(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	
	public int getRandomNum(int n) {
		int num = (int) (n*Math.random());
		return num;
	}

}
