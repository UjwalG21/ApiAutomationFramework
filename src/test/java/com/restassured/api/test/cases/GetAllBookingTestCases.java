package com.restassured.api.test.cases;

import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;
import com.restassured.api.endpoint.APIConstants;

import io.qameta.allure.Description;

public class GetAllBookingTestCases extends BaseTest {

	@Test
	@Description("Get All Bookings")
	public void getAllBookings() {

		// given
		requestSpecification.basePath(APIConstants.GET_BOOKING);

		// when
		response = requestSpecification.when().log().all().get();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);

	}

}
