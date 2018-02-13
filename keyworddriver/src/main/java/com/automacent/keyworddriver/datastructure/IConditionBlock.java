package com.automacent.keyworddriver.datastructure;

import java.util.List;

import com.automacent.keyworddriver.datastructure.impl.Step;
import com.automacent.keyworddriver.enums.Keyword;

public interface IConditionBlock {
	Keyword getKeyword();

	String[] getData();

	public List<Step> getSteps();

	public void addSteps(Step steps);
}
