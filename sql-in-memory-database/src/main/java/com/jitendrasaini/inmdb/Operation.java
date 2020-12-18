package com.jitendrasaini.inmdb;

import java.util.List;

public interface Operation {
	public List<Integer> eval(String column, Object value);
}
