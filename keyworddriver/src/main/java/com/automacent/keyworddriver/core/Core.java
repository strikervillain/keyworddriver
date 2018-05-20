package com.automacent.keyworddriver.core;

import com.automacent.keyworddriver.ds.workflow.Suite;

public class Core {
	private static Suite suite;

	public static Suite getSuite() {
		return suite;
	}

	public static void setSuite(Suite suite) {
		Core.suite = suite;
	}

}
