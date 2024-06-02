package com.herokuapp.restfulbooker;

import com.herokuapp.restfulbooker.data.Booking;
import com.herokuapp.restfulbooker.data.CreateBookingResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingTest extends BaseTest {

    @Test(dataProvider = "bookingDataProvider", dataProviderClass = BookingDataProvider.class, priority = 1)
    public void postCreateBooking(Booking booking) {

        Response response = given()
                .contentType("application/json")
                .spec(requestSpec)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpec)
                .extract().response();

        CreateBookingResponse createBookingResponse = response.getBody().as(CreateBookingResponse.class);
        int bookingid = createBookingResponse.getBookingid();

        Response getResponse = given()
                .spec(requestSpec)
                .when()
                .get("/booking/" + bookingid)
                .then()
                .spec(responseSpec)
                .extract().response();

        Booking getBooking = getResponse.getBody().as(Booking.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String getCheckin = LocalDate.parse(getBooking.getBookingdates().getCheckin(), formatter).toString();
        String getCheckout = LocalDate.parse(getBooking.getBookingdates().getCheckout(), formatter).toString();

        assertThat(getBooking.getBookingdates().getCheckin()).isEqualTo((getCheckin));
        assertThat(getBooking.getBookingdates().getCheckout()).isEqualTo((getCheckout));
        assertThat(getBooking.getFirstname()).isNotNull();
        assertThat(getBooking.getLastname()).isNotEmpty();
        assertThat(getBooking.getTotalprice()).isPositive();
    }

    @Test(priority = 2)
    public void getBookingIds() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("firstname", "Jim");
        queryParams.put("lastname", "Brown");
        queryParams.put("checkin", "2010-06-01");
        queryParams.put("checkout", "2024-06-31");

        Response response = given()
                .spec(requestSpec)
                .queryParams(queryParams)
                .when()
                .get("/booking/")
                .then()
                .spec(responseSpec)
                .extract().response();

        List<Integer> bookingIds = response.path("bookingid");

        for (Integer bookingId : bookingIds) {
            assertThat(bookingId).isNotNull();
            assertThat(bookingId).isPositive();
        }
    }
}