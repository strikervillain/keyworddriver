package com.automacent.keyworddriver.core;

import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.ds.workflow.Row;
import com.automacent.keyworddriver.engine.read.IReadEngine;
import com.automacent.keyworddriver.engine.read.ReadEngine;

public class Executor {

	private List<String> suiteFileLocationList = new ArrayList<>();

	private IReadEngine readEngine = new ReadEngine();

	public Executor(List<String> suiteFileLocationList) {
		super();
		this.suiteFileLocationList = suiteFileLocationList;
	}

	public void constructSuiteMap() {
		for (String suiteFileLocation : suiteFileLocationList) {
			List<Row> rawInfoList = readEngine.readSuite(suiteFileLocation);

			for (Row rawInfo : rawInfoList) {

			}
		}
	}

}
