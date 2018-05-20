package com.automacent.keyworddriver.keywords;

import com.automacent.keyworddriver.anotations.Keyword;
import com.automacent.keyworddriver.anotations.NotEmpty;
import com.automacent.keyworddriver.enums.KeywordType;

public class InternalKeywords {

	@Keyword(type = KeywordType.MODULE)
	public void call(@NotEmpty String moduleName, @NotEmpty String moduleLocation) {
	}
}