package com.automacent.keyworddriver.ds.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suite {
	private String suiteName;
	private File suiteFile;

	private Map<String, Test> testMap = new HashMap<String, Test>();

	public Suite(File suiteFile) {
		super();
		this.suiteFile = suiteFile;
		this.suiteName = suiteFile.getName().replaceAll(".xlsx", "").replaceAll(".xls", "");
	}

	public String getSuiteName() {
		return suiteName;
	}

	public File getSuiteFile() {
		return suiteFile;
	}

	public List<Test> getTests() {
		return new ArrayList<Test>(testMap.values());
	}
	
	public void addTest(Test test) {
		testMap.put(test.getTestName(), test);
	}
}
