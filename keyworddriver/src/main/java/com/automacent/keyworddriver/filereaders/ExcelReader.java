package com.automacent.keyworddriver.filereaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	protected Workbook workbook;
	protected Sheet sheet;

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

	protected void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO throw custom Exception
		}
	}
}
