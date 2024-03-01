package com.travelmate.repository;

import com.travelmate.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The ActivityRepository interface extends the JpaRepository interface
 * and provides methods for accessing and managing activities in the database.
 * It allows CRUD operations on activities.
 *
 * Note: This interface is implemented by Spring Data JPA.
 *
 * @author baraniraj
 * @version 1.0
 * @since   2024-02-28
 */@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByRemainingCapacityGreaterThan(int remainingCapacity);

    List<Activity> findByDestinationId(long id);


}
