package com.travelmate.model;

/**
 * The TravelPackage class represents a package for travel,
 * including a name, passenger capacity, itinerary, and list of passengers.
 * It provides methods to print the itinerary and passenger list.
 *
 * @author Your Name
 * @version 1.0
 * @since   2024-02-28
 */

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Entity

@Data
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int passengerCapacity;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Destination> itinerary = new ArrayList<>();

    @OneToMany(mappedBy = "travelPackage")
    private List<Passenger> passengers = new ArrayList<>();

    public TravelPackage() {
    }

    public TravelPackage(Long id, String name, int passengerCapacity, List<Destination> itinerary, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengers = passengers;
    }

    public TravelPackage(String name, int passengerCapacity) {
        this.name=name;
        this.passengerCapacity=passengerCapacity;

    }

    public TravelPackage(Long id, String name, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
    }

    public Long getId() {
        return id;
    }

    public TravelPackage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TravelPackage setName(String name) {
        this.name = name;
        return this;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public TravelPackage setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        return this;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public TravelPackage setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
        return this;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public TravelPackage setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }
}