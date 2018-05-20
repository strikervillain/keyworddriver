package com.automacent.keyworddriver.exceptions;

import java.io.File;

public class SuiteFileNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7944680445910286726L;

	public SuiteFileNotExistException(File suiteFile) {
		super(String.format("Provided suite file,  %s, does not exist", suiteFile.getAbsolutePath()));
	}

}
