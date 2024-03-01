package com.travelmate;

import com.travelmate.model.*;
import com.travelmate.repository.PassengerRepository;
import com.travelmate.service.PassengerService;
import com.travelmate.service.PassengerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerServiceImpl passengerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePassenger() {
        // Arrange
        Passenger passenger = new Passenger();
        passenger.setName("John");
        passenger.setPassengerNumber("P001");
        passenger.setType(PassengerType.STANDARD);
        passenger.setBalance(100);

        when(passengerRepository.save(passenger)).thenReturn(passenger);

        // Act
        Passenger createdPassenger = passengerService.createPassenger(passenger);

        // Assert
        assertEquals(passenger, createdPassenger);
    }

    @Test
    public void testPrintPassengerDetails() {
        // Arrange
        Passenger passenger = new Passenger();
        passenger.setName("John");
        passenger.setPassengerNumber("P001");
        passenger.setType(PassengerType.STANDARD);
        passenger.setBalance(100);
        // Initialize a new Activity object before each test
        Activity activity = new Activity();
        activity.setName("Eiffel Tower Tour");
        activity.setDescription("Guided tour of the Eiffel Tower");
        activity.setCost(20);
        activity.setCapacity(10);
        Destination dest = new Destination();
        dest.setName("paris");
        activity.setDestination(dest);
        passenger.setActivities(Collections.singletonList(activity));

        // Act
        String details = passenger.toString();

        // Assert
        String expectedDetails = "Name: John\n" +
                "Passenger Number: P001\n" +
                "Passenger Type: STANDARD\n" +
                "Balance: 100.0\n" +
                "Activities:\n" +
                "- Activity Name: Eiffel Tower Tour\n" +
                "  Destination: Paris\n" +
                "  Cost: 20.0\n";
        assertEquals(expectedDetails, details);
    }

}
