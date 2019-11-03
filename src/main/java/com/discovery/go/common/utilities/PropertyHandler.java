package com.discovery.go.common.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {
	
	private static PropertyHandler instance;
	private Properties prop = new Properties();

	private PropertyHandler(String configFile) throws IOException {
		FileInputStream inputStream = new FileInputStream(configFile);
		prop.load(inputStream);
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

	public static PropertyHandler getInstance() throws IOException {
		if (instance == null) {
			String configFile = System.getProperty("user.dir")+"/src/main/resources/config.properties";
			instance = new PropertyHandler(configFile);
		}
		return instance;
	}

	public boolean containsKey(String key) {
		return prop.containsKey(key);
	}
}
