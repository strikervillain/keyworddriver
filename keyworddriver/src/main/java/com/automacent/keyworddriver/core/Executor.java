package com.automacent.keyworddriver.core;

import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.datastructure.impl.RawInfo;
import com.automacent.keyworddriver.datastructure.impl.Suites;
import com.automacent.keyworddriver.engine.read.IReadEngine;
import com.automacent.keyworddriver.engine.read.ReadEngine;

public class Executor {

	private List<String> suiteFileLocationList = new ArrayList<>();
	private Suites suites = new Suites();
	private IReadEngine readEngine = new ReadEngine();

	public Executor(List<String> suiteFileLocationList) {
		super();
		this.suiteFileLocationList = suiteFileLocationList;
	}

	public void constructSuiteMap() {
		for (String suiteFileLocation : suiteFileLocationList) {
			List<RawInfo> rawInfoList = readEngine.readSuite(suiteFileLocation);

			for (RawInfo rawInfo : rawInfoList) {
				List<String> partList = rawInfo.getPart();
			}
		}
	}

}
