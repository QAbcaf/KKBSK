package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kms.katalon.core.annotation.Keyword;

public class WriteExcel {

	@Keyword
	public void writeToExcel(String columnHeader, String valueToInsert, String rowIndex) throws IOException {
		String filePath = "SimulasiKKBSK.xlsx";

		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		int columnIndex = findOrCreateColumnIndex(sheet, columnHeader);

		int rowIndexInt = Integer.parseInt(rowIndex);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				Cell noCell = row.getCell(0);
				if (noCell != null && noCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					double noCellValue = noCell.getNumericCellValue();
					if ((int) noCellValue == rowIndexInt) {
						String cleanValue = valueToInsert.replaceAll("[^0-9]", "");
						int intValue = Integer.parseInt(cleanValue);
						String stringValue = String.valueOf(intValue);

						Cell cell = row.createCell(columnIndex);
						cell.setCellValue(stringValue);
					}
				}
			}
		}

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
	}

	private int findOrCreateColumnIndex(XSSFSheet sheet, String columnHeader) {
		Row headerRow = sheet.getRow(0);
		if (headerRow == null) {
			headerRow = sheet.createRow(0);
		}
		int columnIndex = -1;
		for (int i = 0; i <= headerRow.getLastCellNum(); i++) {
			Cell cell = headerRow.getCell(i);
			if (cell == null) {
				cell = headerRow.createCell(i);
			}
			if (cell.getStringCellValue().trim().equalsIgnoreCase(columnHeader.trim())) {
				columnIndex = i;
				break;
			}
		}
		if (columnIndex == -1) {
			columnIndex = headerRow.getLastCellNum();
			Cell newHeaderCell = headerRow.createCell(columnIndex);
			newHeaderCell.setCellValue(columnHeader);
		}
		return columnIndex;
	}
}
