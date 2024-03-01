package com.travelmate.repository;

import com.travelmate.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The PassengerRepository interface extends the JpaRepository interface
 * and provides methods for accessing and managing passengers in the database.
 * It allows CRUD operations on passengers.
 *
 * Note: This interface is implemented by Spring Data JPA.
 *
 * @author Baraniraj
 * @version 1.0
 * @since   2024-03-01
 */
@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
