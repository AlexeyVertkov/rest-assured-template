package com.herokuapp.restfulbooker;

import com.herokuapp.restfulbooker.data.Booking;
import com.herokuapp.restfulbooker.data.BookingDates;
import org.testng.annotations.DataProvider;

public class BookingDataProvider {
    @DataProvider
    public Object[][] bookingDataProvider() {
        BookingDates validBookingDates = new BookingDates("2024-06-01", "2024-06-30");
        BookingDates invalidBookingDates = new BookingDates("2024.06.01", "2024 06:31");
        return new Object[][]{
                // valid data
                {new Booking("Jim", "Brown", 111, true, validBookingDates, "Breakfast")},

                // firstname is null
                {new Booking(null, "Brown", 111, true, validBookingDates, "Breakfast")},

                // lastname is empty
                {new Booking("Jim", "", 111, true, validBookingDates, "Breakfast")},

                // invalid bookingDates
                {new Booking("Jim", "Brown", 111, true, invalidBookingDates, "Breakfast")},

                // totalprice is a negative
                {new Booking("Jim", "Brown", -111, true, validBookingDates, "Breakfast")},
        };
    }
}