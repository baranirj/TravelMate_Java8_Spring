package com.travelmate.controller;

import com.travelmate.model.Activity;
import com.travelmate.model.Passenger;
import com.travelmate.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    // Create a new passenger
    @PostMapping("/create")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    // Get all passengers
    @GetMapping("/all")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // Get passenger by ID
    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    // Update passenger
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(passenger);
    }

    // Delete passenger
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    // Print passenger details
    @GetMapping("/{id}/details")
    public Passenger getPassengerDetails(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }


}

