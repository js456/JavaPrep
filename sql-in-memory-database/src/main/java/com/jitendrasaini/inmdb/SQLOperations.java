package com.jitendrasaini.inmdb;

public interface SQLOperations<T> {

	public int insert(T t);
	
	public boolean update(T t);
	
	public T find(Filter filter);
	
	public boolean delete(T t);
}
