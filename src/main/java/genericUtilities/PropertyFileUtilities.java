package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtilities {
	public String readPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\KeyValuePairs_PropertyFile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
