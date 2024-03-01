package com.travelmate.repository;

import com.travelmate.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The DestinationRepository interface extends the JpaRepository interface
 * and provides methods for accessing and managing destinations in the database.
 * It allows CRUD operations on destinations.
 *
 * Note: This interface is implemented by Spring Data JPA.
 *
 * @author Baraniraj
 * @version 1.0
 * @since   2024-03-01
 *
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
