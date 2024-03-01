package com.travelmate.repository;

import com.travelmate.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TravelPackageRepository.java

/**
 * The TravelPackageRepository interface extends the JpaRepository interface
 * and provides methods for accessing and managing travel packages in the database.
 * It allows CRUD operations on travel packages.
 *
 * Note: This interface is implemented by Spring Data JPA.
 *
 * @author Baraniraj
 * @version 1.0
 * @since   2024-02-28
 */
@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

}


