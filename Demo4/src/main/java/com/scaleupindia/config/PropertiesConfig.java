package com.scaleupindia.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.scaleupindia.exception.InternalServiceException;

/**
 * @author abhishekvermaa10
 *
 */
public class PropertiesConfig {
	private static final Properties PROPERTIES = new Properties();
	private static final PropertiesConfig PROPERTIES_CONFIG = new PropertiesConfig();
	
	private PropertiesConfig() {
		try (FileReader fileReader = new FileReader("D:\\Real Demos\\Maven\\Workspace2\\Demo2\\src\\main\\resources\\database.properties");) {
			PROPERTIES.load(fileReader);
		} catch (IOException e) {
			throw new InternalServiceException("Failed to load " + e.getMessage());
		}
	}
	
	public static PropertiesConfig getInstance() {
        return PROPERTIES_CONFIG;
    }
	
	public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
