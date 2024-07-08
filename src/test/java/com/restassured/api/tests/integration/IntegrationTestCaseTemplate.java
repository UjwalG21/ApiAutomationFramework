package com.restassured.api.tests.integration;

import org.testng.annotations.Test;

import com.restassured.api.base.BaseTest;

import io.qameta.allure.Description;

public class IntegrationTestCaseTemplate extends BaseTest {

	@Test(groups = "integration", priority = 0)
	@Description("Create new booking information into system")
	public void testCreateBooking() {
	}

	@Test(groups = "integration", priority = 1)
	@Description("Verify the booking id ")
	public void testVerifyBookingId() {

	}

	@Test(groups = "integration", priority = 2)
	@Description("Update the booking information using ID")
	public void testUpdateBookingById() {

	}

	@Test(groups = "integration", priority = 3)
	@Description("Delete the booking information using ID")
	public void testDeletwBookingById() {

	}

}
