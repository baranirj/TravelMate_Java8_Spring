package com.travelmate.service;

import com.travelmate.model.Activity;
import com.travelmate.model.TravelPackage;

public interface TravelPackageService {
    // Create a new travel package
    TravelPackage createTravelPackage(TravelPackage travelPackage);


    // Sign up passenger for an activity in a travel package
    TravelPackage signUpPassengerForActivity(Long packageId, Long passengerId, Activity activity);

    // Add activity to a travel package
    TravelPackage addActivityToPackage(Long packageId, Activity activity);

    // Print itinerary of the travel package
    void printItinerary(Long packageId);

    // Get travel package by ID
    TravelPackage getTravelPackageById(Long id);
}
