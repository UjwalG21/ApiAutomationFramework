package com.restassured.api.module;

import com.google.gson.Gson;
import com.restassured.api.pojo.Authentication;
import com.restassured.api.pojo.Booking;
import com.restassured.api.pojo.BookingDates;

public class Payloads {
	Gson gson;

	public String generatePayloadForCreateBooking() {

		Booking booking = new Booking();
		booking.setFirstname("Thomas");
		booking.setLastname("Harry");
		booking.setTotalprice(10000);
		booking.setDepositpaid(true);

		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2024-01-10");
		bookingDates.setCheckout("2024-01-11");
		booking.setBookingdates(bookingDates);
		booking.setAdditionalneeds("Breakfast");

		gson = new Gson();
		String jsonCreateResponse = gson.toJson(booking);
		return jsonCreateResponse;
	}

	public String generatePayloadForUpdateBooking() {

		Booking booking = new Booking();
		booking.setFirstname("Richard");
		booking.setLastname("Noah");
		booking.setTotalprice(25000);
		booking.setDepositpaid(true);

		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2025-10-10");
		bookingDates.setCheckout("2026-10-11");
		booking.setBookingdates(bookingDates);
		booking.setAdditionalneeds("Breakfast,Dinner");

		gson = new Gson();
		String jsonUpdateResponse = gson.toJson(booking);
		return jsonUpdateResponse;
	}

	public String authenticationPayLoad() {
		Authentication authentication = new Authentication();
		authentication.setUsername("admin");
		authentication.setPassword("password123");

		gson = new Gson();
		String authPayload = gson.toJson(authentication);
		return authPayload;

	}

}
