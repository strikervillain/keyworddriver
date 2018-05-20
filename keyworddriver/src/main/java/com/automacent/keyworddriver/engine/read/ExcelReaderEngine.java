package com.automacent.keyworddriver.engine.read;

import java.io.File;
import java.util.List;

import com.automacent.keyworddriver.ds.primitive.Line;
import com.automacent.keyworddriver.filereaders.ExcelReader;

public class ExcelReaderEngine extends ExcelReader implements IReadEngine {

	@Override
	public List<Line> getLinesInSuite(File suiteFile) {
		openWorkbook(suiteFile);
		loadSheet();
		List<Line> lines = readRows();
		closeWorkbook();
		return lines;
	}

	@Override
	public List<Line> getLinesInTest(File testFile, String testName) {
		openWorkbook(testFile);
		loadSheet(testName);
		List<Line> lines = readRows();
		closeWorkbook();
		return lines;
	}
}
