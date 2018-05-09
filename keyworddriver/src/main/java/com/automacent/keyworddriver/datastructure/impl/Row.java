package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

public class RawInfo {
	private List<String> part = new ArrayList<>();

	public List<String> getPart() {
		return part;
	}

	public void addPart(String part) {
		this.part.add(part);
	}

}
