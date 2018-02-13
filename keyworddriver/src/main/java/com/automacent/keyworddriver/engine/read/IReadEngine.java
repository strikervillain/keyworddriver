package com.automacent.keyworddriver.engine.read;

import java.util.List;

import com.automacent.keyworddriver.datastructure.impl.RawInfo;

public interface IReadEngine {
	List<RawInfo> readSuite(String suiteFile);

	List<RawInfo> readTest(String testName);

	List<RawInfo> readBlock(String blockName);
}
