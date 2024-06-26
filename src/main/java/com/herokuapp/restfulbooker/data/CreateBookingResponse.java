package com.herokuapp.restfulbooker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingResponse {
    private int bookingid;
    private Booking booking;
}