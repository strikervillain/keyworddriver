package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suites {
	private Map<String, Suite> suiteMap = new HashMap<String, Suite>();

	public List<Suite> getSuiteList() {
		return new ArrayList<Suite>(suiteMap.values());
	}

	public void addSuite(String suiteName) {
		// TODO Throw exception if same name exists
		this.suiteMap.put(suiteName, new Suite(suiteName));
	}

	public Suite getSuite(String suiteName) {
		return suiteMap.get(suiteName);
	}

}
