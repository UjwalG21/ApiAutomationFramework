package com.restassured.api.test.cases;

import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;
import com.restassured.api.endpoint.APIConstants;
import com.restassured.api.pojo.Authentication;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;

public class TokenGenerationTestCases extends BaseTest {

	Authentication authentication;

	@Test(priority = 1)
	@Description("Generate new token using invalid credentials Valid username,Invalid Password")
	public void generateTokenUsingValidUsernameInvalidPassword() {

		authentication = new Authentication();
		authentication.setUsername("admin");
		authentication.setPassword("password12323");
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

	@Test(priority = 2)
	@Description("Generate new token using invalid credentials InValid username,valid Password")
	public void generateTokenUsingInValidUsernameValidPassword() {

		authentication = new Authentication();
		authentication.setUsername("admin123");
		authentication.setPassword("password123");
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

	@Test(priority = 3)
	@Description("Generate new token using invalid credentials InValid username,Invalid Password")
	public void generateTokenUsingInValidUsernameInvalidPassword() {

		authentication = new Authentication();
		authentication.setUsername("admin123");
		authentication.setPassword("password12332");
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

	@Test(priority = 4)
	@Description("Generate new token using blank inputs")
	public void generateTokenUsingBlankInputs() {

		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

	@Test(priority = 5)
	@Description("Generate new token using special chracters as inputs")
	public void generateTokenUsingSpecialCharactersInputs() {

		authentication = new Authentication();
		authentication.setUsername("!@#$^");
		authentication.setPassword("&%@");
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

	@Test(priority = 6)
	@Description("Generate new token using only numbers as inputs")
	public void generateTokenUsingNumbersAsInputs() {

		authentication = new Authentication();
		authentication.setUsername("123456");
		authentication.setPassword("9875532");
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(authentication);

		response = requestSpecification.when().log().all().post();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}

}
