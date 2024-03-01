package com.travelmate.model;


/**
 * The Activity class represents an activity available at a destination,
 * including a name, description, cost, and capacity.
 * It provides methods to enroll passengers for the activity.
 *
 * @author Your Name
 * @version 1.0
 * @since   2024-03-01
 */

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int remainingCapacity; // Track remaining capacity

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<ActivitySubscription> subscriptions = new ArrayList<>();

    // Activity.java
    @ManyToMany
    @JoinTable(
            name = "activity_passenger",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers = new ArrayList<>();

    public Activity(Long id, String name, String description, double cost, int capacity, int remainingCapacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.remainingCapacity = remainingCapacity;
    }

    public Activity() {
    }

    public Activity( String name, String description, double cost, int capacity, int remainingCapacity, Destination destination, List<ActivitySubscription> subscriptions, List<Passenger> passengers) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.remainingCapacity = remainingCapacity;
        this.destination = destination;
        this.subscriptions = subscriptions;
        this.passengers = passengers;
    }

    public Long getId() {
        return id;
    }

    public Activity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Activity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Activity setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Activity setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public Activity setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public Activity setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
        return this;
    }

    public Destination getDestination() {
        return destination;
    }

    public Activity setDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public List<ActivitySubscription> getSubscriptions() {
        return subscriptions;
    }

    public Activity setSubscriptions(List<ActivitySubscription> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", remainingCapacity=" + remainingCapacity +
                ", destination=" + destination +
                ", subscriptions=" + subscriptions +
                '}';
    }


}
