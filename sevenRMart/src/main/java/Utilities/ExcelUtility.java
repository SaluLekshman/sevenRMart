package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	public static ArrayList<String> getString(String file_path, String sheet) {
		try {

			f = new FileInputStream(file_path);
			wb = new XSSFWorkbook(f);
			sh = wb.getSheet(sheet);
			ArrayList<String> ExcelRows = new ArrayList<String>();
			int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			for (int i = 0; i <= rowCount; i++) {
				Row row = sh.getRow(i);
				int cellCount = row.getLastCellNum();
				for (int j = 0; j < cellCount; j++) {
					ExcelRows.add(row.getCell(j).getStringCellValue());
				}
			}
			return ExcelRows;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static ArrayList<String> get(String file_path, String sheet, int rownum) {
		try {

			f = new FileInputStream(file_path);
			wb = new XSSFWorkbook(f);
			sh = wb.getSheet(sheet);
			ArrayList<String> ExcelRows = new ArrayList<String>();
			Row row = sh.getRow(rownum);
			int cellCount = row.getLastCellNum();
			for (int j = 0; j < cellCount; j++) {
				ExcelRows.add(row.getCell(j).getStringCellValue());
			}
			return ExcelRows;
		}

		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getString(int i, int j, String file_path, String sheet) {
		try {
			f = new FileInputStream(file_path);
			wb = new XSSFWorkbook(f);
			sh = wb.getSheet(sheet);
			Row r = sh.getRow(i);
			Cell c = r.getCell(j);
			return c.getStringCellValue();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return sheet;

	}

	public static String getNumeric(int i, int j, String file_path, String sheet) {
		try 
		{
			f = new FileInputStream(file_path);
			wb = new XSSFWorkbook(f);
			sh = wb.getSheet(sheet);
			Row r = sh.getRow(i);
			Cell c = r.getCell(j);
			int value = (int) c.getNumericCellValue();
			return String.valueOf(value);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return sheet;
	}

}