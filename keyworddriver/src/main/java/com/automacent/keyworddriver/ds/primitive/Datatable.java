package com.automacent.keyworddriver.ds.primitive;

import java.util.HashMap;
import java.util.Map;

public class Datatable {
	private Map<String, String> dataMap = new HashMap<>();
	
	public void addData(String key, String data) {
		dataMap.put(key, data);
	}
	
	public String getData(String key) {
		return dataMap.get(key);
	}
	
	
}
