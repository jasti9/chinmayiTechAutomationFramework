package com.framework.payloads;

public class ChatGPTPayload {
	
	public static String chatGPTMessage(String msg) {
		return "{\r\n" + 
				"    \"model\": \"gpt-3.5-turbo\",\r\n" + 
				"    \"messages\": [{ \"role\": \"user\", \"content\": \"" + msg + "\" }]\r\n" + 
				"}";
	}


}
