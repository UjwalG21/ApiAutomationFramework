package com.restassured.api.test.cases;

import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;
import com.restassured.api.endpoint.APIConstants;

import io.qameta.allure.Description;

public class GetBookingsTestCases extends BaseTest {

	@Test
	@Description("Get All Bookings")
	public void getAllBookings() {

		requestSpecification.basePath(APIConstants.GET_BOOKING);

		response = requestSpecification.when().log().all().get();

		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);

	}
}
