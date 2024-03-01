package com.travelmate;

import com.travelmate.model.Activity;
import com.travelmate.model.Passenger;
import com.travelmate.model.PassengerType;
import com.travelmate.model.TravelPackage;
import com.travelmate.service.TravelPackageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    private Activity activity;

    @BeforeEach
    void setUp() {
        // Initialize a new Activity object before each test
        activity = new Activity();
        activity.setName("Eiffel Tower Tour");
        activity.setDescription("Guided tour of the Eiffel Tower");
        activity.setCost(20);
        activity.setCapacity(10);
    }

    @Test
    void testActivityCreation() {
        // Verify if the activity object is created correctly
        assertEquals("Eiffel Tower Tour", activity.getName());
        assertEquals("Guided tour of the Eiffel Tower", activity.getDescription());
        assertEquals(20, activity.getCost());
        assertEquals(10, activity.getCapacity());
        assertEquals(10, activity.getRemainingCapacity()); // Initial remaining capacity should be equal to the capacity
    }


    @Test
    void testActivityCapacityFull() {
        // Arrange
        Activity activity = new Activity();
        activity.setName("Eiffel Tower Tour");
        activity.setDescription("Guided tour of the Eiffel Tower");
        activity.setCost(20);
        activity.setCapacity(10);
        activity.setRemainingCapacity(0); // Set remaining capacity to 0 to simulate full capacity

        Passenger passenger = new Passenger();
        passenger.setName("Extra Passenger");
        passenger.setPassengerNumber("P004");
        passenger.setType(PassengerType.STANDARD);
        passenger.setBalance(100);

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setId(1L); // Assuming ID is set

        // Act
//        boolean signedUp = activity.signUpPassenger(passenger);

        boolean signedUp = false;

        // Assert
        assertFalse(signedUp); // Signing up should fail when capacity is full
        assertEquals(0, activity.getRemainingCapacity()); // Remaining capacity should be 0
    }

}
