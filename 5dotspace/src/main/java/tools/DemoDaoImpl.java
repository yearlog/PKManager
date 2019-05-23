package tools;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DemoDaoImpl extends SqlSessionDaoSupport implements DemoDao{

	public Demo queryDemo()
	{
		SqlSession sqlSession = this.getSqlSession();
		Demo demo = sqlSession.selectOne("tools.queryDemo");
		System.out.println(demo.getName());
		return demo;
	}
	
	public void createTable(String tableName)
	{
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.selectOne("tools.createTable",tableName);
	}
}
