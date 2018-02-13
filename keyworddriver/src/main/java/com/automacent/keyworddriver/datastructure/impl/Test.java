package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

public class Test {
	private String name;
	private boolean execute;

	private List<Step> steps = new ArrayList<Step>();

	public Test(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isExecute() {
		return execute;
	}

	public void setExecute(boolean execute) {
		this.execute = execute;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public void addStep(Step step) {
		this.steps.add(step);
	}

}
