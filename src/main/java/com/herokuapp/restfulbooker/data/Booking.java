package com.herokuapp.restfulbooker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }
}

