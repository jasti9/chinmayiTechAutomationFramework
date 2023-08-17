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
