package com.restassured.api.base;

import org.testng.annotations.BeforeTest;

import com.restassured.api.actions.Assertions;
import com.restassured.api.endpoint.APIConstants;
import com.restassured.api.module.DeserilizedResponse;
import com.restassured.api.module.Payloads;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public RequestSpecification requestSpecification;
	public Response response;
	public ValidatableResponse validatableResponse;
	public Assertions assertions;
	public JsonPath jsonPath;
	public Payloads payloads;
	public DeserilizedResponse deserilizedResponse;

	@BeforeTest
	public void setupConfiguration() {
		System.out.println("Before test");

		assertions = new Assertions();
		payloads = new Payloads();
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri(APIConstants.BASE_URL);
		requestSpecification.contentType(ContentType.JSON);

	}

	public String generateToken() {
		payloads = new Payloads();
		deserilizedResponse = new DeserilizedResponse();
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri(APIConstants.BASE_URL);
		requestSpecification.basePath(APIConstants.AUTH_URL);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(payloads.authenticationPayLoad());

		response = requestSpecification.when().log().all().post();

		String generatedToken = deserilizedResponse.captureToken(response.asString());
		return generatedToken;

	}
}
