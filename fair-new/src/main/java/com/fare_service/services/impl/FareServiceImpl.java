package com.fare_service.services.impl;

import com.fare_service.exception.FareNotFoundException;
import org.springframework.stereotype.Service;

import com.fare_service.model.Fare;
import com.fare_service.repository.FareRepository;
import com.fare_service.services.FareService;

@Service
public class FareServiceImpl implements FareService {

    private final FareRepository fareRepository;

    public FareServiceImpl(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    @Override
    public Fare getFareByFlightNumber(String flightNumber) {
    	
        return fareRepository.findByFlightNumber(flightNumber);
    }

    @Override
    public Fare saveFare(Fare fare) {
        return fareRepository.save(fare);
    }
    @Override
    public Fare updateFare(String flightNumber, Fare updatedFare) {
        Fare existingFare = fareRepository.findByFlightNumber(flightNumber);
        if (existingFare == null) {
            throw new FareNotFoundException("Fare not found for flight number: " + flightNumber);
        }
        existingFare.setFare(updatedFare.getFare());
        return fareRepository.save(existingFare);
    }

    @Override
    public void deleteFare(String flightNumber) {
        Fare fare = fareRepository.findByFlightNumber(flightNumber);
        if (fare == null) {
            throw new FareNotFoundException("Fare not found for flight number: " + flightNumber);
        }
        fareRepository.delete(fare);
    }
}
