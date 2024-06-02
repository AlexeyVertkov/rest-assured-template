package com.herokuapp.restfulbooker.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class CreateBookingResponse{
	private int bookingid;
	private Booking booking;
}