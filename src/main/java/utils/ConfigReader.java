package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			properties.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties");
		}
	}
	
	public static String get(String key) {
		String value = System.getProperty(key);
		if(value!=null && !value.isEmpty()) {
			return value;
		}
		
		return properties.getProperty(key);
	}
}
