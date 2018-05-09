package com.automacent.keyworddriver.engine.read;

import java.util.List;

import com.automacent.keyworddriver.datastructure.impl.Row;

public interface IReadEngine {
	List<Row> readSuite(String suiteFile);

	List<Row> readTest(String testName);
	
	List<Row> readTestData(String testName);

	List<Row> readBlock(String blockName);
}
