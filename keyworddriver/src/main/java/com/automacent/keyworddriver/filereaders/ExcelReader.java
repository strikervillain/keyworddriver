package com.automacent.keyworddriver.filereaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automacent.keyworddriver.ds.primitive.Line;

public class ExcelReader {
	
	private Workbook workbook;
	private Sheet sheet;

	protected void openWorkbook(File file) {
		FileInputStream excelFileInputStream = null;
		try {
			excelFileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			// TODO throw custom exception
		}
		try {
			if (file.getAbsolutePath().endsWith(".xlsx"))
				workbook = new XSSFWorkbook(excelFileInputStream);
			else
				workbook = new HSSFWorkbook(excelFileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO throw custom exception
		}
	}

	protected void loadSheet() {
		sheet = workbook.getSheetAt(0);
	}

	protected void loadSheet(String sheetName) {
		sheet = workbook.getSheet(sheetName);
	}

	protected List<Line> readRows() {
		List<Line> lines = new ArrayList<>();

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Line line = new Line();

			Row currentRow = rowIterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					line.addSegment(currentCell.getStringCellValue());
				} else {
					System.out.println("Cells must be formatted as string");
					// TODO Throw exception stating the cells must be formatted as string
				}
			}
			lines.add(line);
		}
		return lines;
	}

	protected void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO throw custom Exception
		}
	}

}
