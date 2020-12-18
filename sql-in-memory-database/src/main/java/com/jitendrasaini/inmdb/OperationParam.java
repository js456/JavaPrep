package com.jitendrasaini.inmdb;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class OperationParam {

	private int lastRowId;

	private int maxNumberOfRows;

	private IndexConfig indexConfig;

	private Object data[];

	private Stack<Integer> emptyRowIdStack;

	private Map<String, TreeMap<Object, List<Integer>>> dataMapping;

	public OperationParam(int lastRowId, int maxNumberOfRows, IndexConfig indexConfig, Object[] data,
			Stack<Integer> emptyRowIdStack, Map<String, TreeMap<Object, List<Integer>>> dataMapping) {
		this.lastRowId = lastRowId;
		this.maxNumberOfRows = maxNumberOfRows;
		this.indexConfig = indexConfig;
		this.data = data;
		this.emptyRowIdStack = emptyRowIdStack;
		this.dataMapping = dataMapping;
	}

	public int getLastRowId() {
		return lastRowId;
	}

	public int getMaxNumberOfRows() {
		return maxNumberOfRows;
	}

	public IndexConfig getIndexConfig() {
		return indexConfig;
	}

	public Object[] getData() {
		return data;
	}

	public Stack<Integer> getEmptyRowIdStack() {
		return emptyRowIdStack;
	}

	public Map<String, TreeMap<Object, List<Integer>>> getDataMapping() {
		return dataMapping;
	}

	public void setLastRowId(int lastRowId) {
		this.lastRowId = lastRowId;
	}

	public void setMaxNumberOfRows(int maxNumberOfRows) {
		this.maxNumberOfRows = maxNumberOfRows;
	}

	public void setIndexConfig(IndexConfig indexConfig) {
		this.indexConfig = indexConfig;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public void setEmptyRowIdStack(Stack<Integer> emptyRowIdStack) {
		this.emptyRowIdStack = emptyRowIdStack;
	}

	public void setDataMapping(Map<String, TreeMap<Object, List<Integer>>> dataMapping) {
		this.dataMapping = dataMapping;
	}

}
