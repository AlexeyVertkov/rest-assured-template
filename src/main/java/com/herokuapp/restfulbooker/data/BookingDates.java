package com.herokuapp.restfulbooker.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class BookingDates {
    private String checkin;
    private String checkout;
}
