package com.automacent.keyworddriver.ds.step;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Loop implements IStep {
	private SingleStep conditionStep;

	private List<IStep> steps = new ArrayList<>();
}
