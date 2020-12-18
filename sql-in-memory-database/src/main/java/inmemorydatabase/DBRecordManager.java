package inmemorydatabase;

import java.util.Map;

public interface DBRecordManager {
	
	public boolean insert(String tableName, Map<String, Object>rowData);
}
