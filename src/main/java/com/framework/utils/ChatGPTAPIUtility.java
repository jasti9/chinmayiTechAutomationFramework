package com.framework.utils;

import static io.restassured.RestAssured.given;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.framework.enums.APIConstants;
import com.framework.payloads.ChatGPTPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.*;

public class ChatGPTAPIUtility {
	
	String chatGPTToken;
	
	private void connectToChatGPTApi() {

		RestAssured.baseURI = APIConstants.BASEURI.getValue();
		chatGPTToken = APIConstants.CHATGPT_TOKEN.getValue();
		
	}

	private String requestContent(String contentRequested) {

		String apiResponse = given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + chatGPTToken).log().all()
				.body(ChatGPTPayload.chatGPTMessage(contentRequested)).when()
				.post(APIConstants.CHATGPT_POSTREQUEST.getValue()).then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		return apiResponse;

	}

	private void saveResponseToFile(String apiResponse, String fileName) throws IOException {

		JsonPath js = new JsonPath(apiResponse);

		int noOfContents = js.getInt("choices.size()");
		
		BufferedWriter fWriter;
		String path;

		for (int i = 0; i < noOfContents; i++) {
			String msg = js.get("choices[" + i + "].message.content");
			path = System.getProperty("user.dir") + "\\files\\" + "ChatGPTfile_" + fileName + ".txt";
			fWriter = new BufferedWriter(new FileWriter(path));
			fWriter.write(msg);
			fWriter.close();
		}

	}
	
	
	public void saveResponseFromChatGPT(String contentRequested, String fileName) {
		connectToChatGPTApi();
		String apiResponse = requestContent(contentRequested);
		try {
			saveResponseToFile(apiResponse,fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
