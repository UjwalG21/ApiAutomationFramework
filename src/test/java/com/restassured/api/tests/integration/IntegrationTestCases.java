package com.restassured.api.tests.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;
import com.restassured.api.endpoint.APIConstants;
import com.restassured.api.pojo.Booking;
import com.restassured.api.pojo.BookingResponse;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;

public class IntegrationTestCases extends BaseTest {

	@Test(groups = "integration", priority = 0)
	@Description("Create new booking information into system")
	public void testCreateBookingIntoSystem(ITestContext iTestContext) {
		iTestContext.setAttribute("token", generateToken());
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

		// set booking id
		iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());
	}

	@Test(groups = "integration", priority = 1)
	@Description("Verify the booking information using booking id ")
	public void testVerifyBookingInformationUsingId(ITestContext iTestContext) {

		// given
		String bookingId = iTestContext.getAttribute("bookingid").toString();
		String getById = APIConstants.GET_BOOKING + "/" + bookingId;
		requestSpecification.basePath(getById);

		// when
		response = requestSpecification.when().log().all().get();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);

		Booking booking = deserilizedResponse.getBookingById(response.asString());

		// assertJ
		assertThat(booking.getFirstname()).isNotNull();
		assertThat(booking.getLastname()).isNotNull();

	}

	@Test(groups = "integration", priority = 2)
	@Description("Update the booking information using ID")
	public void testUpdateBookingById(ITestContext iTestContext) {
		String token = iTestContext.getAttribute("token").toString();
		String bookingId = iTestContext.getAttribute("bookingid").toString();
		String updateBooking = APIConstants.CREATE_OR_UPDATE_BOOKING + "/" + bookingId;

		// given
		requestSpecification.basePath(updateBooking);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.cookie("token", token);
		requestSpecification.body(payloads.generatePayloadForUpdateBooking());

		// when
		response = requestSpecification.when().log().all().put();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);

		// deserilization
		Booking booking = deserilizedResponse.updateBookingResponseDeserialized(response.asString());

		// assertJ
		assertThat(booking.getFirstname()).isNotNull().isAlphabetic();
		assertThat(booking.getLastname()).isNotNull().isAlphabetic();

	}

	@Test(groups = "integration", priority = 3)
	@Description("Delete the booking information using ID")
	public void testDeleteBookingById(ITestContext iTestContext) {

		String token = iTestContext.getAttribute("token").toString();
		String bookingId = iTestContext.getAttribute("bookingid").toString();
		String deleteBooking = APIConstants.DELETE_BOOKING + "/" + bookingId;

		// Given
		requestSpecification.basePath(deleteBooking);
		requestSpecification.cookie("token", token);

		// when
		response = requestSpecification.log().all().delete();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(201);

	}

	@Test(groups = "integration", priority = 4)
	@Description("Verify the deleted booking information")
	public void testDisplayDeletedBookingInformation(ITestContext iTestContext) {

		String bookingId = iTestContext.getAttribute("bookingid").toString();
		String validateBooking = APIConstants.GET_BOOKING + "/" + bookingId;

		// Given
		requestSpecification.basePath(validateBooking);

		// when
		response = requestSpecification.log().all().get();

		// then
		validatableResponse = response.then().log().all();
		validatableResponse.statusCode(404);

	}
}