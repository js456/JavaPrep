package inmemorydatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDatabase implements DatabaseOperations {

	private String databaseName;
	private Map<String, Table> tables;

	private SQLDatabase() {
		tables = new HashMap<String, Table>();
	};

	private static class SQLDatabaseHelper {
		public static final SQLDatabase dbInstance = new SQLDatabase();
	}

	public static SQLDatabase getInstance() {
		return SQLDatabase.SQLDatabaseHelper.dbInstance;
	}

	@Override
	public boolean createTable(String tableName, List<Column> columns) {
		if (null == tableName)
			throw new IllegalArgumentException("table name can not be empty");
		if (null == columns || columns.size() <= 0)
			throw new IllegalArgumentException("Specify at lease one column");
		if (tables.get(tableName) != null) {
			System.out.println("table is present in the database");
			return false;
		}
		Table table = new Table(tableName, columns);
		tables.put(tableName, table);
		System.out.println("Table create with the name of "+tableName);
		return true;
	}

	@Override
	public boolean dropTable(String tableName) throws DatabaseException {
		if(null == tableName)
			throw new IllegalArgumentException("Table name can't be null");
		if(tables.get(tableName) == null)
			throw new DatabaseException("Table not present in the db");
		tables.remove(tableName);
		System.out.println("Dropped table:"+tableName);
		return true;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public Map<String, Table> getTables() {
		return tables;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public void setTables(Map<String, Table> tables) {
		this.tables = tables;
	}

	@Override
	public boolean insert(String tableName, Map<String, Object> rowData) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
