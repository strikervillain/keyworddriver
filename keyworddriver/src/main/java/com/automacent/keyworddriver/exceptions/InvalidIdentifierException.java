package com.automacent.keyworddriver.exceptions;

public class InvalidIdentifierException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1720446313727383473L;

	public InvalidIdentifierException(String type, String value) {
		super(String.format("Invalid Identifier %s = %s", type, value));
	}

}
