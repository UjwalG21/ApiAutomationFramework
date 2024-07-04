package com.restassured.api.module;

import com.google.gson.Gson;
import com.restassured.api.pojo.Booking;
import com.restassured.api.pojo.BookingDates;
import com.restassured.api.pojo.BookingResponse;

public class Payloads {
	Gson gson;

	public String generatePayload() {

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
		String jsonResponse = gson.toJson(booking);
		return jsonResponse;
	}

	public String updatePayload() {

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
		// return gson.toJson(booking);
		return null;
	}

	public BookingResponse bookingResponseDeserialized(String responseString) {
		Gson gson = new Gson();
		BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
		return bookingResponse;

	}

}
