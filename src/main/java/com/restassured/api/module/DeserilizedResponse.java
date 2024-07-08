package com.restassured.api.module;

import com.google.gson.Gson;
import com.restassured.api.pojo.Booking;
import com.restassured.api.pojo.BookingResponse;
import com.restassured.api.pojo.TokenResponse;

public class DeserilizedResponse {

	Gson gson;

	public BookingResponse bookingResponseDeserialized(String responseString) {
		gson = new Gson();
		BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
		return bookingResponse;

	}

	public String captureToken(String token) {
		gson = new Gson();
		TokenResponse tokenResponse = gson.fromJson(token, TokenResponse.class);
		return tokenResponse.getToken();
	}

	public Booking getBookingById(String getByIdResponse) {
		gson = new Gson();
		Booking booking = gson.fromJson(getByIdResponse, Booking.class);
		return booking;

	}

	public Booking updateBookingResponseDeserialized(String responseString) {
		gson = new Gson();
		Booking booking = gson.fromJson(responseString, Booking.class);
		return booking;

	}

}
