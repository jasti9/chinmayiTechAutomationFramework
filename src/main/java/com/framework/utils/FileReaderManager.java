package com.framework.utils;

import com.framework.dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	private ConfigFileReader config;
	
	public FileReaderManager(String filePath)
    {
		config = new ConfigFileReader(filePath);
    }

	/*
	public static synchronized FileReaderManager getInstance()
    {
        if (fileReader == null)
        	fileReader = new FileReaderManager();
        return fileReader;
    }
    
    */
	
	public ConfigFileReader getConfigReader() {
		return config;	
	}
}
