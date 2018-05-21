package ReviewClass_043018;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//create methods to reuse code, make values more dynamic, and avoid dependencies and hardcoding

public class excelUtilityReview {
	FileInputStream fis;
	XSSFWorkbook xlWb;
	XSSFSheet xlSheet;

	public void excelBook(String filePath) throws IOException {
		fis = new FileInputStream(filePath);
		xlWb = new XSSFWorkbook(fis);
	}

	public String excelData(int sheetNumber, int rowNumber, int cellNumber) throws IOException {
		xlSheet = xlWb.getSheetAt(sheetNumber);
		String xlValue = xlSheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();

		return xlValue;
	}

	public int rowCount(int sheetNumber) {
		int rows = xlWb.getSheetAt(sheetNumber).getLastRowNum();

		return rows+1;
	}

	public int cellCount (int SheetNumber) {
		int cells = xlWb.getSheetAt(SheetNumber).getRow(0).getLastCellNum();
		
		return cells;
	}
}
