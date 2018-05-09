package com.automacent.keyworddriver.ds.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suite {
	private String name;
	private Map<String, Workflow> testMap = new HashMap<String, Workflow>();

	public Suite(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Workflow> getTestList() {
		return new ArrayList<Workflow>(testMap.values());
	}
}
