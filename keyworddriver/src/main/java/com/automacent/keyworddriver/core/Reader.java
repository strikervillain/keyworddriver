package com.automacent.keyworddriver.core;

import java.io.File;
import java.util.List;

import com.automacent.keyworddriver.ds.primitive.Line;
import com.automacent.keyworddriver.ds.workflow.Suite;
import com.automacent.keyworddriver.ds.workflow.Test;
import com.automacent.keyworddriver.engine.read.ExcelReaderEngine;
import com.automacent.keyworddriver.engine.read.IReadEngine;

public class Reader {

	private Suite suite;

	public void constructExecutionMap(String suiteFileLocation) {
		File suiteFile = new File(suiteFileLocation);
		constructSuite(suiteFile);
		constructTests();
	}

	private void constructSuite(File suiteFile) {
		IReadEngine readEngine = null;

		// TODO Check suite file exists
		// TODO Check suite file is file
		String suiteFileAbsolutePath = suiteFile.getAbsolutePath();
		if (suiteFileAbsolutePath.endsWith(".xlsx") || suiteFileAbsolutePath.endsWith("xlx")) {
			readEngine = new ExcelReaderEngine();
		}
		// TODO If readEngine == null throw exception

		List<Line> lines = readEngine.getLinesInSuite(suiteFile);

		// TODO Logic to check if first line is heading before removing
		lines.remove(0);

		// TODO Exception when lines is 0

		// TODO Remove this
		for (Line line : lines) {
			System.out.println(line.getSegments());
		}

		suite = new Suite(suiteFile);
		for (Line line : lines) {
			List<String> segments = line.getSegments();

			// TODO Throw Exception on each segment not found or empty
			Test test = new Test();
			test.setTestName(segments.get(0));
			test.setExecute(segments.get(1));
			test.setTestFile(segments.get(2));
			test.setDataFile(segments.get(3));
			suite.addTest(test);
		}
	}

	private void constructTests() {
		List<Test> tests = suite.getTests();
		for (Test test : tests) {
			constructTest(test);
			constructTestData(test);
		}
	}

	private void constructTest(Test test) {
		IReadEngine readEngine = null;

		// TODO Check test file exists
		// TODO Check test file is file
		String testFileAbsolutePath = test.getTestFile().getAbsolutePath();
		if (testFileAbsolutePath.endsWith(".xlsx") || testFileAbsolutePath.endsWith("xlx")) {
			readEngine = new ExcelReaderEngine();
		}

		List<Line> lines = readEngine.getLinesInTest(test.getTestFile(), test.getTestName());
		// TODO Remove this
		for (Line line : lines) {
			System.out.println(line.getSegments());
		}

	}

	private void constructTestData(Test test) {
		// TODO code
	}

	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.constructExecutionMap("C:\\keyword_driver\\regression_suite.xlsx");
	}
}
