package tools;

import org.apache.ibatis.annotations.Param;

public interface DemoDao {

	public Demo queryDemo();
	
	public void createTable(String tableName);
}
