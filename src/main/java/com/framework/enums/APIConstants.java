package com.framework.enums;

public enum APIConstants {

	BASEURI("https://api.openai.com/v1/"),
	CHATGPT_TOKEN("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"),
	CHATGPT_POSTREQUEST("chat/completions");

	private String value;

	private APIConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
