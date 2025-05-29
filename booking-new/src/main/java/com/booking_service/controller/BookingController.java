package com.booking_service.controller;


import com.booking_service.model.Booking;
import org.springframework.web.bind.annotation.*;

import com.booking_service.dto.BookingRequest;
import com.booking_service.dto.BookingResponse;
import com.booking_service.services.BookingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest request) {
    	logger.info("Received booking request for flight: {}", request.getFlightNumber());
    	return bookingService.createBooking(request);
    }

    @PutMapping("/updateCheckIn/{bookingReference}")
    public String updateCheckInStatus(@PathVariable String bookingReference) {
    	logger.info("Check-in update requested for booking reference: {}", bookingReference);
        return bookingService.updateCheckInStatus(bookingReference);
    }
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        logger.info("Fetching all bookings (owner access)");
        return bookingService.getAllBookings();
    }
}


