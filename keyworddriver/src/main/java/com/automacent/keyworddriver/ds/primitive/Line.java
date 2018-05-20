package com.automacent.keyworddriver.ds.primitive;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private List<String> segment= new ArrayList<>();

	
	public List<String> getSegments() {
		return segment;
	}

	public void addSegment(String segment) {
		this.segment.add(segment);
	}

}
