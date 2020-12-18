package inmemorydatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Table {

	String tableName;
	List<Column> columns;
	Map<String,Column>columnMap;
	List<Column>primaryKey;
	private List<Map<Column, Object>> rows = new LinkedList<>();
	
	public Table(String tableName, List<Column> columns) {
		this.tableName = tableName;
		this.columns = columns;
		columnMap = new HashMap<String, Column>();
		columns.forEach(col->{
			columnMap.put(col.getColumnName(), col);
		});
	}

	public String getTableName() {
		return tableName;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	public Map<String, Column> getColumnMap() {
		return columnMap;
	}

	public void setColumnMap(Map<String, Column> columnMap) {
		this.columnMap = columnMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
		result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (columns == null) {
			if (other.columns != null)
				return false;
		} else if (!columns.equals(other.columns))
			return false;
		if (tableName == null) {
			if (other.tableName != null)
				return false;
		} else if (!tableName.equals(other.tableName))
			return false;
		return true;
	}

}
