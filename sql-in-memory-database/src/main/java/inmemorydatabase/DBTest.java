package inmemorydatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest {
	
	
	public static void createTable() {
		
		SQLDatabase database = SQLDatabase.getInstance();
		Column column = new Column.ColumnBuilder("departmentId",DataType.INTEGER).build();
		Column departmentName = new Column.ColumnBuilder("departmentName",DataType.STRING).build();
		List<Column>columnList = new ArrayList<Column>();
		columnList.add(column);
		columnList.add(departmentName);
		database.createTable("Department", columnList);
	}
	
	public static void printTables() {
		SQLDatabase database = SQLDatabase.getInstance();
		Map<String, Table> tables = database.getTables();
		tables.forEach((key,value)->System.out.println(key));
	}
	
	public void test(Object obj) {
		System.out.println(obj.getClass().getName());
	}
	
	public static void main(String[] args) {
		//createTable();
		//printTables();
		
		DBTest test = new DBTest();
		test.test("dsf");
	}
}
