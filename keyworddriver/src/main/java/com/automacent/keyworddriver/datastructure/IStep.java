package com.automacent.keyworddriver.datastructure;

import com.automacent.keyworddriver.datastructure.impl.Identifier;
import com.automacent.keyworddriver.enums.Keyword;

public interface IStep {

	Keyword getKeyword();

	Identifier getIdentifier();

	String[] getData();

}
