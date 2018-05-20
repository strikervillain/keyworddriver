package com.automacent.keyworddriver.engine.read;

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

public class ExcelReader implements IReadEngine {

	public boolean isFileFound() {
		// TODO Auto-generated method stub
		/**
		 * 
		 * Code required
		 * 
		 */
		return true;
	}

	public List<Line> getLinesInSuite(File suiteFile) {
		loadWorkbook(suiteFile);
		loadSheet();
		return readRows();
	}

	protected Workbook workbook;
	protected Sheet sheet;

	private void loadWorkbook(File suiteFile) {
		FileInputStream excelFile = null;
		try {
			excelFile = new FileInputStream(suiteFile);
		} catch (FileNotFoundException e) {
			/**
			 * Throw exception here
			 */
		}

		try {
			if (suiteFile.getAbsolutePath().endsWith(".xlsx"))
				workbook = new XSSFWorkbook(excelFile);
			else
				workbook = new HSSFWorkbook(excelFile);
		} catch (IOException e) {
			/*
			 * Throw Exception
			 * 
			 */
		}
	}

	private void loadSheet() {
		sheet = workbook.getSheetAt(0);
	}

	private List<Line> readRows() {
		List<Line> lines = new ArrayList<>();

		Iterator<Row> rowIterator = sheet.iterator();

		int count = 0;

		while (rowIterator.hasNext()) {

			Row currentRow = rowIterator.next();

			if (count++ > 0) {
				Iterator<Cell> cellIterator = currentRow.iterator();
				Line line = new Line();
				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();

					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						line.addSegment(currentCell.getStringCellValue());
					} else {
						/**
						 * 
						 * Throw exception stating the cells must be formatted as string
						 * 
						 * 
						 */
						System.out.println("------------------------------- cells must be formatted as string");

					}
				}

				lines.add(line);
			}

		}

		return lines;
	}

	private void closeWoerkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Line> getLinesInTest(File testFile, String testName) {
		// TODO Auto-generated method stub
		return null;
	}
}
