package com.travelmate.service;

import com.travelmate.model.Destination;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * The DestinationServiceImpl class implements the DestinationService interface
 * and provides methods for managing destinations.
 * It includes CRUD operations for destinations and retrieval methods.
 *
 * Responsibilities:
 * - Retrieve destinations by travel package ID.
 * - Retrieve a destination by its ID.
 * - Add, update, and delete destinations.
 * - Retrieve all destinations.
 *
 *
 * @author Your Baraniraj
 * @version 1.0
 * @since   2024-03-01
 */

@Service
public class DestinationServiceImpl implements DestinationService {



    @Override
    public List<Destination> getDestinationsByTravelPackageId(int travelPackageId) throws SQLException {
        return null;
    }

    @Override
    public Destination getDestinationById(int id) {
        return null;
    }

    @Override
    public void addDestination(Destination destination) {

    }

    @Override
    public void updateDestination(Destination destination) {

    }

    @Override
    public void deleteDestination(int id) {

    }

    @Override
    public List<Destination> getAllDestinations() {
        return null;
    }
}
