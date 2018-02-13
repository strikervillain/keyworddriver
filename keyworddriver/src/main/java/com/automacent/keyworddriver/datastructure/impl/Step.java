package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.datastructure.IConditionBlock;
import com.automacent.keyworddriver.datastructure.IStep;
import com.automacent.keyworddriver.datastructure.IStepBlock;
import com.automacent.keyworddriver.enums.Keyword;

public class Step implements IStep, IStepBlock, IConditionBlock {
	private Keyword keyword;
	private Identifier identifier;
	private String[] data;

	private List<Step> steps = new ArrayList<Step>();

	public Step(Keyword keyword, Identifier identifier, String... data) {
		super();
		this.keyword = keyword;
		this.identifier = identifier;
		this.data = data;
	}

	public Step(Keyword keyword, String... data) {
		super();
		this.keyword = keyword;
		this.data = data;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public String[] getData() {
		return data;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void addSteps(Step steps) {
		this.steps.add(steps);
	}
}
