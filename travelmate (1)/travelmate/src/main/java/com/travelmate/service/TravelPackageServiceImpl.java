package com.travelmate.service;


/**
 * The TravelPackageServiceImpl class implements the TravelPackageService interface
 * and provides methods for managing travel packages and their associated activities.
 * It includes operations for creating, updating, and enrolling passengers in activities.
 *
 * Responsibilities:
 * - Create a new travel package.
 * - Add activities to a travel package.
 * - Sign up passengers for activities within a travel package, handling capacity constraints and balance deduction.
 * - Print the itinerary of a travel package.
 * - Retrieve a travel package by ID.
 *
 * Note: This class is annotated with @Service to indicate that it is a Spring service component.
 * It interacts with the TravelPackageRepository, ActivityRepository, and PassengerRepository for data access operations.
 *
 * @author Your baraniraj
 * @version 1.0
 * @since   2024-02-29
 */


import com.travelmate.model.*;
import com.travelmate.repository.ActivityRepository;
import com.travelmate.repository.TravelPackageRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.travelmate.model.*;
import com.travelmate.repository.ActivityRepository;
import com.travelmate.repository.PassengerRepository;
import com.travelmate.repository.TravelPackageRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public TravelPackage createTravelPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    @Override
    public TravelPackage addActivityToPackage(Long packageId, Activity activity) {
        TravelPackage travelPackage = getTravelPackageById(packageId);
        if (travelPackage != null) {
//            activity.setTravelPackage(travelPackage);
            travelPackage.getItinerary().add(activity.getDestination());
            return travelPackageRepository.save(travelPackage);
        }
        return null;
    }

    @Override
    public TravelPackage signUpPassengerForActivity(Long packageId, Long passengerId, Activity activity) {
        TravelPackage travelPackage = getTravelPackageById(packageId);
        if (travelPackage != null) {
            Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
            if (passenger != null) {
                if (activity.getRemainingCapacity() > 0) {
                    double cost = calculateCost(passenger.getType(), activity.getCost());
                    if (passenger.getBalance() >= cost || passenger.getType() == PassengerType.PREMIUM) {
                        passenger.getActivities().add(activity);

                        activity.setRemainingCapacity(activity.getRemainingCapacity() - 1);
                        if (passenger.getType() != PassengerType.PREMIUM) {
                            passenger.setBalance(passenger.getBalance() - cost);
                        }
                        return travelPackageRepository.save(travelPackage);
                    } else {
                        System.out.println("Insufficient balance for the passenger.");
                    }
                } else {
                    System.out.println("Activity is already full.");
                }
            } else {
                System.out.println("Passenger not found.");
            }
        } else {
            System.out.println("Travel package not found.");
        }
        return null;
    }

    @Override
    public void printItinerary(Long packageId) {
        TravelPackage travelPackage = getTravelPackageById(packageId);
        if (travelPackage != null) {
            System.out.println("Travel Package: " + travelPackage.getName());
            for (Destination destination : travelPackage.getItinerary()) {
                System.out.println("Destination: " + destination.getName());
                List<Activity> activityList = activityRepository.findByDestinationId(destination.getId());

                if (activityList.isEmpty()) {
                    System.out.println("|| NO  ACTIVITIES CREATED FOR THE DESTINATION!");

                } else {
                    for (Activity activity : activityList) {
                        System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() +
                                ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
                    }
                }
            }
        } else {
            System.out.println("Travel package not found.");
        }
    }

    @Override
    public TravelPackage getTravelPackageById(Long id) {
        return travelPackageRepository.findById(id).orElse(null);
    }

    // Helper method to calculate cost based on passenger type
    private double calculateCost(PassengerType type, double originalCost) {
        switch (type) {
            case STANDARD:
                return originalCost;
            case GOLD:
                return originalCost * 0.9; // Apply 10% discount
            case PREMIUM:
                return 0; // Free for premium passengers
            default:
                return originalCost;
        }
    }
}
