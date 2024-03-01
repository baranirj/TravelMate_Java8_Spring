package com.travelmate;

import com.travelmate.model.*;
import com.travelmate.repository.TravelPackageRepository;
import com.travelmate.service.TravelPackageService;
import com.travelmate.service.TravelPackageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class TravelPackageServiceTest {

    @Mock
    private TravelPackageRepository travelPackageRepository;

    @InjectMocks
    private TravelPackageServiceImpl travelPackageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTravelPackage() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        when(travelPackageRepository.save(travelPackage)).thenReturn(travelPackage);

        // Act
        TravelPackage createdPackage = travelPackageService.createTravelPackage(travelPackage);

        // Assert
        assertEquals(travelPackage.getName(), createdPackage.getName());
        assertEquals(travelPackage.getPassengerCapacity(), createdPackage.getPassengerCapacity());
    }

    @Test
    public void testAddActivityToPackage() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Destination destination = new Destination();
        destination.setName("Paris");
        Activity activity = new Activity();
        activity.setDescription("Guided tour of the Eiffel Tower");
        activity.setName("Eiffel Tower Tour");
        activity.setCost(10000);
        activity.setCapacity(20);
//        //1,"Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 20, 10
        activity.setDestination(destination);

        travelPackage.setItinerary(Collections.singletonList(destination));
        when(travelPackageRepository.save(travelPackage)).thenReturn(travelPackage);

        // Act
        TravelPackage updatedPackage = travelPackageService.addActivityToPackage(1L, activity);

        // Assert
        assertEquals(travelPackage.getItinerary(), updatedPackage.getItinerary());
    }

    //signUp a Passenger for activity
    @Test
    public void testSignUpPassengerForActivity() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setName("Europe Trip");
        travelPackage.setPassengerCapacity(10);

        Destination destination = new Destination();
        destination.setName("Paris");

        Passenger passenger = new Passenger();
        passenger.setId(1L); // Assuming the ID is set
        passenger.setName("John");
        passenger.setPassengerNumber("P001");
        passenger.setType(PassengerType.STANDARD);
        passenger.setBalance(100);

        Activity activity = new Activity();
        activity.setId(1L); // Assuming the ID is set
        activity.setName("Eiffel Tower Tour");
        activity.setDescription("Guided tour of the Eiffel Tower");
        activity.setCost(20);
        activity.setCapacity(10);

//        destination.setActivities(Collections.singletonList(activity));
        travelPackage.setPassengers(Collections.singletonList(passenger));
        travelPackage.setItinerary(Collections.singletonList(destination));
        when(travelPackageRepository.findById(1L)).thenReturn(java.util.Optional.of(travelPackage));

        // Act
        TravelPackage updatedPackage = travelPackageService.signUpPassengerForActivity(1L, 1L, activity);

        // Assert
        assertNotNull(updatedPackage);
        assertEquals(1, passenger.getActivities().size());
    }



}
