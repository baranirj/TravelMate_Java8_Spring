package com.travelmate.model;


/**
 * The Passenger class represents a passenger in a travel package,
 * including a name, passenger number, type, balance (if applicable),
 * and list of activities enrolled.
 * It provides methods to enroll in activities and print details.
 *
 * @author Your Name
 * @version 1.0
 * @since   2024-02-28
 */

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String passengerNumber;
    private PassengerType type;
    private double balance;


    @ManyToMany(mappedBy = "passengers")
    private List<Activity> activities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "travel_package_id")
    private TravelPackage travelPackage;

    public Passenger() {
    }

    public Passenger(Long id, String name, String passengerNumber, PassengerType type, double balance) {
        this.id = id;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
    }

    public Passenger(Long id, String name, String passengerNumber, PassengerType type, double balance, List<Activity> activities, TravelPackage travelPackage) {
        this.id = id;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
        this.activities = activities;
        this.travelPackage = travelPackage;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public Passenger setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Passenger setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public Passenger setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
        return this;
    }

    public PassengerType getType() {
        return type;
    }

    public Passenger setType(PassengerType type) {
        this.type = type;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Passenger setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public Passenger setActivities(List<Activity> activities) {
        this.activities = activities;
        return this;
    }



    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengerNumber='" + passengerNumber + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", activities=" + activities +
                '}';
    }
}
