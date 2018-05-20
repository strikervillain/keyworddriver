package com.automacent.keyworddriver.ds.step;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SingleStep implements IStep {

	private String stepName;

	private List<Object> args = new ArrayList<Object>();

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public List<Object> getArgs() {
		return args;
	}

	public void setArgs(List<Object> args) {
		this.args = args;
	}
}
