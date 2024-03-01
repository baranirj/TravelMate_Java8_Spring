package com.travelmate.service;

import com.travelmate.model.Activity;
import com.travelmate.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAllPassengers();
    Passenger getPassengerById(long id);
    void addPassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
    void deletePassenger(long id);

    void signUpForActivity(Passenger passenger, Activity activity);

    Passenger createPassenger(Passenger passenger);
}
