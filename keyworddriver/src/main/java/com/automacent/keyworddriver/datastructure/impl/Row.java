package com.automacent.keyworddriver.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private List<String> cells = new ArrayList<>();

	public List<String> getCell() {
		return cells;
	}

	public void addCell(String cell) {
		this.cells.add(cell);
	}
}
