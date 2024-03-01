package com.travelmate.model;

import jakarta.persistence.*;

// ActivitySubscription.java


@Entity
public class ActivitySubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Activity activity;

    public ActivitySubscription() {
    }

    public Long getId() {
        return id;
    }

    public ActivitySubscription setId(Long id) {
        this.id = id;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public ActivitySubscription setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Activity getActivity() {
        return activity;
    }

    public ActivitySubscription setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public ActivitySubscription(Long id, Passenger passenger, Activity activity) {
        this.id = id;
        this.passenger = passenger;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "ActivitySubscription{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", activity=" + activity +
                '}';
    }
}
