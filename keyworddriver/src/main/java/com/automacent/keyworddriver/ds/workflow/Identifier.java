package com.automacent.keyworddriver.ds.workflow;

import org.openqa.selenium.By;

import com.automacent.keyworddriver.exceptions.InvalidIdentifierException;

public class Identifier {
	
	private String type;
	private String value;
	private By by;

	public Identifier(String type, String value) throws InvalidIdentifierException {
		super();
		this.type = type;
		this.value = value;

		generateBy();
	}

	private void generateBy() throws InvalidIdentifierException {
		if (type.equalsIgnoreCase("ID"))
			by = By.id(value);
		else if (type.equalsIgnoreCase("NAME"))
			by = By.name(value);
		else if (type.equalsIgnoreCase("XPATH"))
			by = By.xpath(value);
		else if (type.equalsIgnoreCase("CSS"))
			by = By.cssSelector(value);
		else if (type.equalsIgnoreCase("LINK_TEXT"))
			by = By.linkText(value);
		else if (type.equalsIgnoreCase("PARTIAL_LINK_TEXT"))
			by = By.partialLinkText(value);
		else if (type.equalsIgnoreCase("CLASS"))
			by = By.tagName(value);
		else if (type.equalsIgnoreCase("TAG_NAME"))
			by = By.tagName(value);
		else
			throw new InvalidIdentifierException(type, value);
	}

	public By getIdentifier() {
		return by;
	}
}
