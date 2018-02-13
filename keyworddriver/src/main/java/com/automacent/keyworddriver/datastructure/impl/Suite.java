package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suite {
	private String name;
	private Map<String, Test> testMap = new HashMap<String, Test>();

	public Suite(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Test> getTestList() {
		return new ArrayList<Test>(testMap.values());
	}

	public void addTest(Test test) {
		// TODO Throw exception if same name exists
		this.testMap.put(test.getName(), test);
	}
}
