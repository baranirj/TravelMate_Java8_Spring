package com.travelmate.service;

import com.travelmate.model.Activity;

import java.util.List;
import java.util.Optional;

import com.travelmate.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The ActivityService class provides logic for managing activities and registering passengers in activities.
 * It includes methods for CRUD operations on activities and enrolling passengers in activities.
 *
 * Responsibilities:
 * - CRUD operations for activities, such as creating, reading, updating, and deleting activities.
 * - Registering passengers in activities, handling capacity constraints.
 *
 * @author Your Name
 * @version 1.0
 * @since   2024-03-01
 */

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity createActivity(Activity activity) {

        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {

        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getAvailableActivities() {

        return activityRepository.findByRemainingCapacityGreaterThan(0);
    }

    @Override
    public void printAvailableActivities() {
        List<Activity> availableActivities = getAvailableActivities();
        System.out.println("Available Activities:");
        for (Activity activity : availableActivities) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName() + ", Remaining Capacity: " + activity.getRemainingCapacity());
        }
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.getReferenceById(id);
    }


    @Override
    // Update activity
    public Activity updateActivity(Long id, Activity updatedActivity) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) {
            updatedActivity.setId(id);
            return activityRepository.save(updatedActivity);
        } else {
            return null;
        }
    }

    // Delete activity

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }




}






