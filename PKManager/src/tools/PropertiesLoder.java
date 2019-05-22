package tools;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoder {
	
	public static Properties getProperty(String url)
	{
		InputStream in = null;
		Properties pro = new Properties();
		try
		{
			in = PropertiesLoder.class.getResourceAsStream(url);
			pro.load(in);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pro; 
	}
	public static String getText(String name) {
		Properties pro = getProperty("../api.properties");
		return pro.getProperty(name);
				
	}
	
	

}
