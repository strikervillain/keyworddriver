package com.automacent.keyworddriver.ds.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.ds.step.IStep;

@SuppressWarnings("all")
public class Test {
	private String testName;
	private File testFile;
	private File dataFile;
	private boolean execute;
	private List<IStep> steps = new ArrayList<>();

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public File getTestFile() {
		return testFile;
	}

	public void setTestFile(String testFileLocation) {
		this.testFile = new File(testFileLocation);
		if (!testFile.exists() || !testFile.isFile()) {
			throw new RuntimeException("File not found");
		}
		
	}

	public File getDataFile() {
		return dataFile;
	}

	public void setDataFile(String dataFileLocation) {
		this.dataFile = new File(dataFileLocation);
		if (!dataFile.exists() || !dataFile.isFile()) {
			throw new RuntimeException("File not found");
		}
		
	}

	public void setExecute(boolean execute) {
		this.execute = execute;
	}

	public boolean isExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		execute = execute.trim().toLowerCase();
		System.out.println(execute);
		if (execute.equals("t") || execute.equals("true") || execute.equals("y") || execute.equals("yes"))
			this.execute = true;
		else if (execute.equals("f") || execute.equals("false") || execute.equals("n") || execute.equals("no"))
			this.execute = false;
		else
			throw new RuntimeException("Value in execute should be ");
	}

	public List<IStep> getSteps() {
		return steps;
	}

	public void setSteps(List<IStep> steps) {
		this.steps = steps;
	}

}
