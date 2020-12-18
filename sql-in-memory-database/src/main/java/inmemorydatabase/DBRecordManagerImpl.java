package inmemorydatabase;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DBRecordManagerImpl implements DBRecordManager{

	public boolean insert(String tableName, Map<String, Object> rowData) {
		
		SQLDatabase database = SQLDatabase.getInstance();
		Map<String, Table> tables = database.getTables();
		Table table = tables.get(tableName);
		if(table == null) {
			throw new IllegalArgumentException("Table doesn't exist");
		}
		if(!validate(table,rowData)) {
			throw new IllegalArgumentException("Provided column data is not valid");
		}
		return false;
	}
	
	public boolean validate(Table table, Map<String, Object>rowData) {
		Map<String,Column> columnsMap = table.getColumnMap();
		boolean validated = true;
		rowData.forEach((columnName,columnValue)->{});
		for(Entry entry:rowData.entrySet()) {
			Column column = columnsMap.get(entry.getKey());
			String className = entry.getValue().getClass().getName();
			if(!className.equalsIgnoreCase("java.lang.Integer")&& ((Integer)entry.getValue())<=DataType.INTEGER.endRange && ((Integer)entry.getValue())>=DataType.INTEGER.startRange) {
				return false;
			}
			else if(!className.equalsIgnoreCase("java.lang.String") && (((String)entry.getValue()).length()<= DataType.STRING.endRange) && (((String)entry.getValue()).length()>= DataType.STRING.startRange)) {
				return false;
			}
		}
		
		return true;
	}

}
