package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.ds.step.IStep;

@SuppressWarnings("all")
public class Workflow {
	private String workflowName;
	private String workflowLocation;
	private String dataLocation;
	private List<IStep> steps = new ArrayList<>();
}
