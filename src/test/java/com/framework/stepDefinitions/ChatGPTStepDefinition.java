package com.framework.stepDefinitions;

import org.apache.log4j.Logger;

import com.framework.enums.APIConstants;
import com.framework.payloads.ChatGPTPayload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ChatGPTStepDefinition {

	Logger log = Logger.getLogger(LoginStepDefinition.class);
	String chatGPTToken;
	String apiResponse;

	@Given("I establish connection with ChatGPT")
	public void connectToChatGPTApi() {
		RestAssured.baseURI = APIConstants.BASEURI.getValue();
		chatGPTToken = APIConstants.CHATGPT_TOKEN.getValue();
		log.info("Base URI is" + RestAssured.baseURI);
		log.info("Token is" + chatGPTToken);

	}

	@When("I request for {string}")
	public void requestContent(String contentRequested) {
		
		apiResponse = given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + chatGPTToken).log().all()
				.body(ChatGPTPayload.chatGPTMessage(contentRequested)).when()
				.post(APIConstants.CHATGPT_POSTREQUEST.getValue()).then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

	}

	@Then("I save the chatGPT response in file {string}")
	public void saveResponseToFile(String fileName) throws IOException {
		
		JsonPath js = new JsonPath(apiResponse);
		
		int noOfContents = js.getInt("choices.size()");
		log.info("Number of response" + noOfContents);
		BufferedWriter fWriter;
		String path;
		
		for(int i = 0; i< noOfContents;i++) {
			String msg = js.get("choices[" + i + "].message.content");
			log.info("****** CHAT GPT RESPONSE ****" + msg);
			path = System.getProperty("user.dir") + "\\files\\" + "ChatGPTfile_" + fileName + ".txt";
			fWriter = new BufferedWriter(new FileWriter(path));
			fWriter.write(msg);
			fWriter.close();
		}

	}

}
