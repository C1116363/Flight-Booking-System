package com.booking_service.services;

import com.booking_service.dto.BookingRequest;
import com.booking_service.dto.BookingResponse;
import com.booking_service.model.Booking;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request);
    String updateCheckInStatus(String bookingReference);
    List<Booking> getAllBookings();
}




