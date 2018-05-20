package com.automacent.keyworddriver.engine.read;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.automacent.keyworddriver.ds.primitive.Line;
import com.automacent.keyworddriver.filereaders.ExcelReader;

public class ExcelReaderEngine extends ExcelReader implements IReadEngine {

	@Override
	public List<Line> getLinesInSuite(File suiteFile) {
		openWorkbook(suiteFile);
		loadSheet();
		List<Line> lines = generateLineList();
		closeWorkbook();
		return lines;
	}

	@Override
	public List<Line> getLinesInTest(File testFile, String testName) {
		openWorkbook(testFile);
		loadSheet(testName);
		List<Line> lines = generateLineList();
		closeWorkbook();
		return lines;
	}
	
	protected List<Line> generateLineList() {
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
}
