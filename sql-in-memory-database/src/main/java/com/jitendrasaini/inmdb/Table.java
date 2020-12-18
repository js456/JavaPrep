package com.jitendrasaini.inmdb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Table<T> implements SQLOperations<T> {

	private int lastRowId;

	private int maxNumberOfRows;

	private IndexConfig indexConfig;

	private Object data[];

	private Stack<Integer> emptyRowIdStack;

	private Map<String, TreeMap<Object, List<Integer>>> dataMapping;

	public Table(int maxNumberOfRows, IndexConfig indexConfig) {

		this.maxNumberOfRows = maxNumberOfRows;
		this.indexConfig = indexConfig;
		this.emptyRowIdStack = new Stack<Integer>();
		this.dataMapping = new HashMap<String, TreeMap<Object, List<Integer>>>();
		for (String index : indexConfig.getColIndexes()) {
			dataMapping.put(index, new TreeMap<Object, List<Integer>>());
		}
		data = new Object[maxNumberOfRows];
	}

	public int insert(T bean) {
		Integer emptyRowId = getEmptyRowId();
		try {
			data[emptyRowId] = bean;
			for (String index : indexConfig.getColIndexes()) {
				Field field;
				field = bean.getClass().getDeclaredField(index);
				field.setAccessible(true);
				Object value = field.get(bean);
				List<Integer> list = dataMapping.get(index).get(value);
				if (null == list) {
					dataMapping.get(index).put(value, new ArrayList<Integer>());
				}
				dataMapping.get(index).get(value).add(emptyRowId);
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public T find(Filter filter) {

		BSTFilterNode root = new BSTFilterNode();
		OperationFactory factory = new OperationFactory(
				new OperationParam(lastRowId, maxNumberOfRows, indexConfig, data, emptyRowIdStack, dataMapping));
		
		return null;
	}

	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	private Integer getEmptyRowId() {
		Integer emptyRow = emptyRowIdStack.pop();
		if ((!emptyRowIdStack.isEmpty()) && null != emptyRow) {
			return emptyRow;
		} else {
			return ++lastRowId;
		}
	}

}
