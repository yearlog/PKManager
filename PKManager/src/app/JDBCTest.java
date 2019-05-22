package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tools.PropertiesLoder;

public class JDBCTest {
	public static void main(String[] args) {
		String driveName = PropertiesLoder.getText("SQLiteDriver");
		Connection con = null;
		String sql  = "select * from test";
		try {
			Class.forName(driveName);
			con = DriverManager.getConnection("jdbc:sqlite:D:\\2I\\Databases\\SQLiteData\\PKManager.db");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(2));;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
