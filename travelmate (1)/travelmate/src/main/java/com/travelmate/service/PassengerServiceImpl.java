package com.travelmate.service;

import com.travelmate.model.Activity;
import com.travelmate.model.ActivitySubscription;
import com.travelmate.model.Passenger;
import com.travelmate.model.PassengerType;
import com.travelmate.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The PassengerServiceImpl class implements the PassengerService interface
 * and provides methods for managing passengers and their activities.
 * It includes operations for enrolling passengers, managing their details,
 * and signing them up for activities.
 *
 * Responsibilities:
 * - Enroll passengers in the system.
 * - Retrieve all passengers.
 * - Retrieve a passenger by ID.
 * - Add, update, and delete passengers.
 * - Sign up passengers for activities, handling balance deduction and capacity constraints.
 * - Create a new passenger.
 *
 * It interacts with the PassengerRepository for data access operations.
 *
 * @author baraniraj
 * @version 1.0
 * @since   2024-03-01
 */

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger enrollPassenger(Passenger passenger) {

        return passengerRepository.save(passenger);
    }


    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(long id) {
        return passengerRepository.getReferenceById(id);
    }

    @Override
    public void addPassenger(Passenger passenger) {

        passengerRepository.save(passenger);

    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {

        passengerRepository.save(passenger);

        return passenger;
    }

    @Override
    public void deletePassenger(long id) {

        passengerRepository.deleteById(id);

    }

    public void signUpForActivity(Passenger passenger, Activity activity) {
        // Check if the passenger has sufficient balance or is a premium passenger
        if (passenger.getType() == PassengerType.PREMIUM ||
                (passenger.getBalance() >= activity.getCost() && passenger.getType() != PassengerType.STANDARD)) {
            ActivitySubscription subscription = new ActivitySubscription();
            subscription.setPassenger(passenger);
            subscription.setActivity(activity);
            activity.getSubscriptions().add(subscription);
            activity.setRemainingCapacity(activity.getRemainingCapacity() - 1);

            // Deduct cost from balance based on passenger type
            if (passenger.getType() == PassengerType.GOLD) {
                double discountedCost = activity.getCost() * 0.9;
                passenger.setBalance(passenger.getBalance() - discountedCost);
            } else if (passenger.getType() == PassengerType.STANDARD) {
                passenger.setBalance(passenger.getBalance() - activity.getCost());
            }

            passengerRepository.save(passenger);
        } else {
            throw new IllegalArgumentException("Passenger does not have sufficient balance to sign up for activity.");
        }
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
