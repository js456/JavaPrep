package inmemorydatabase;

import java.util.List;

public interface DatabaseOperations {

	public abstract boolean createTable(String tableName, List<Column>columns);
	public abstract boolean dropTable(String tableName) throws DatabaseException;
	
}		

/*
 * S - Single responsibility design
 * O - Open for extension and closed for modification
 * L - Liskov Substitution
 * I - Interface Segregation
 * D - Dependency Inversion principle
 */
