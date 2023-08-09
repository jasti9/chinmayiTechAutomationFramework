package com.framework.utils;

import com.framework.dataProviders.ConfigFileReader;

public class FileReaderManager {
	private static FileReaderManager fileReader = null;
	private static ConfigFileReader config;
	
	private FileReaderManager()
    {
		config = new ConfigFileReader();
    }

	public static synchronized FileReaderManager getInstance()
    {
        if (fileReader == null)
        	fileReader = new FileReaderManager();
        return fileReader;
    }
	
	public static ConfigFileReader getConfigReader() {
		return config;	
	}
}
