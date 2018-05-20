package com.automacent.keyworddriver.keywords;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automacent.keyworddriver.anotations.Keyword;
import com.automacent.keyworddriver.anotations.NotEmpty;
import com.automacent.keyworddriver.enums.KeywordType;

public class UIKeywords {
	private UIKeywords(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	private WebDriver getDriver() {
		return driver;
	}

	private static Map<WebDriver, UIKeywords> uiKeywordsMap = new HashMap<>();

	public UIKeywords getActions(WebDriver driver) {
		UIKeywords keywords = uiKeywordsMap.get(driver);
		if (keywords == null) {
			keywords = new UIKeywords(driver);
			uiKeywordsMap.put(driver, keywords);
		}
		return keywords;
	}

	@Keyword(type = KeywordType.SINGLE_STEP)
	public void sendKeys(@NotEmpty String by, @NotEmpty String identifier, String data) {
		getDriver();
	}

	@Keyword(type = KeywordType.SINGLE_STEP)
	public void click(@NotEmpty String by, @NotEmpty String identifier) {
		getDriver();
	}
}