package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.ds.step.IStep;

@SuppressWarnings("all")
public class Module {
	private String moduleName;
	private List<IStep> steps = new ArrayList<>();
}
