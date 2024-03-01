package com.travelmate.service;

import com.travelmate.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityService {
    Activity createActivity(Activity activity);

    List<Activity> getAllActivities();

    List<Activity> getAvailableActivities();

    void printAvailableActivities();

    Activity getActivityById(Long toIntExact);

    // Update activity
    Activity updateActivity(Long id, Activity updatedActivity);

    void deleteActivity(Long id);
}
