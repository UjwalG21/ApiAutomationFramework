package com.restassured.api.tests.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;
import com.restassured.api.endpoint.APIConstants;
import com.restassured.api.pojo.BookingResponse;

import io.qameta.allure.Description;

public class CreateNewBooking extends BaseTest {

	@Test
	@Description("Create new booking into system")
	public void createBooking() {

		// given
		requestSpecification.basePath(APIConstants.CREATE_OR_UPDATE_BOOKING);
		requestSpecification.body(payloads.generatePayloadForCreateBooking());

		// when
		response = requestSpecification.when().log().all().post();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);

		// deserialization
		BookingResponse bookingResponse = deserilizedResponse.bookingResponseDeserialized(response.asString());

		// AssertJ
		assertThat(bookingResponse.getBookingid()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotNull();
		assertThat(bookingResponse.getBooking().getLastname()).isNotNull();

		// TestNg Assertions
		assertions.verifyStatusCode(response);

	}

}
