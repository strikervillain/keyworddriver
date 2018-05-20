package com.automacent.keyworddriver.core;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.automacent.keyworddriver.ds.primitive.Line;
import com.automacent.keyworddriver.ds.workflow.Suite;
import com.automacent.keyworddriver.ds.workflow.Test;
import com.automacent.keyworddriver.engine.read.ExcelReader;
import com.automacent.keyworddriver.engine.read.IReadEngine;

public class Reader {

	private Suite suite;

	public Reader() {

	}

	public void constructExecutionMap(String suiteFileLocation) {
		File suiteFile = new File(suiteFileLocation);
		constructSuite(suiteFile);
		constructTests();
	}

	private void constructSuite(File suiteFile) {
		IReadEngine readEngine = null;

		/**
		 * Check suite file exists
		 */

		String suiteFileAbsolutePath = suiteFile.getAbsolutePath();
		if (suiteFileAbsolutePath.endsWith(".xlsx") || suiteFileAbsolutePath.endsWith("xlx")) {
			readEngine = new ExcelReader();
		}

		/**
		 * If readEngine == null thhrow exception
		 * 
		 */

		List<Line> lines = readEngine.getLinesInSuite(suiteFile);
		lines.remove(0);
		/**
		 * Exception when keywordlines is 0
		 */

		System.out.println(lines.size() + "-----------------------------------");
		
		for (Line line : lines) {
			System.out.println(line.getSegments());
		}

		suite = new Suite(suiteFile);

		for (Line line : lines) {
			List<String> segments = line.getSegments();
			System.out.println(segments.size());
			Test test = new Test();
			test.setTestName(segments.get(0));
			test.setExecute(segments.get(1));
			test.setTestFile(segments.get(2));
			// Throw Exception on each segment not found
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

		String testFileAbsolutePath = test.getTestFile().getAbsolutePath();
		if (testFileAbsolutePath.endsWith(".xlsx") || testFileAbsolutePath.endsWith("xlx")) {
			readEngine = new ExcelReader();
		} 

		List<Line> lines = readEngine.getLinesInTest(test.getTestFile(), test.getTestName());
		for (Line line : lines) {
			System.out.println(line.getSegments());
		}

		for (Line line : lines) {
			Iterator<String> segmentIterator = line.getSegments().iterator();
			String keyword  = segmentIterator.next();
			
			
		}
		
	}

	private void constructTestData(Test test) {

	}

	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.constructExecutionMap("C:\\keyword_driver\\regression_suite.xlsx");
	}
}
