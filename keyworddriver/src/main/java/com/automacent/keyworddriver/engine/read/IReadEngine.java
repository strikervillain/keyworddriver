package com.automacent.keyworddriver.engine.read;

import java.io.File;
import java.util.List;

import com.automacent.keyworddriver.ds.primitive.Line;

public interface IReadEngine {

	List<Line> getLinesInSuite(File suiteFile);

	List<Line> getLinesInTest(File testFile, String testName);
}
