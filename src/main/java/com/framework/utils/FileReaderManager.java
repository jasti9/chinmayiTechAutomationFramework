package com.framework.utils;

import com.framework.dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	private ConfigFileReader config;
	
	public FileReaderManager(String filePath)
    {
		config = new ConfigFileReader(filePath);
    }
	
	public ConfigFileReader getConfigReader() {
		return config;	
	}
}
