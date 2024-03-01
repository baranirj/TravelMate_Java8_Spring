package com.travelmate.model;


import jakarta.persistence.*;

/**
 * The Destination class represents a destination within a travel package,
 * including a name and a list of activities available at that destination.
 * It provides methods to add activities and get available activities.
 *
 * @author Your Name
 * @version 1.0
 * @since   2024-28-02
 */

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Relationship with TravelPackage
    @ManyToOne
    private TravelPackage travelPackage;

    public Destination() {
    }

    public Destination(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Destination(Long id, String name, TravelPackage travelPackage) {
        this.id = id;
        this.name = name;
        this.travelPackage = travelPackage;
    }

    public Long getId() {
        return id;
    }

    public Destination setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Destination setName(String name) {
        this.name = name;
        return this;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public Destination setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
        return this;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", travelPackage=" + travelPackage +
                '}';
    }
}