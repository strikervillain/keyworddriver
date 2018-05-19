package com.automacent.keyworddriver.ds.step;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.IstringHelper;

@SuppressWarnings("all")
public class SingleCondition implements IStep {

	private SingleStep conditionStep;

	private List<IStep> steps = new ArrayList<>();
}
