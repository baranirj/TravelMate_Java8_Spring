package com.travelmate.controller;

import com.travelmate.model.Activity;
import com.travelmate.model.Passenger;
import com.travelmate.service.ActivityService;
import com.travelmate.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ActivityController.java
@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/{activityId}/sign-up/{passengerId}")
    public void signUpForActivity(@PathVariable Long activityId, @PathVariable Long passengerId) {
        Activity activity = activityService.getActivityById(activityId);
        Passenger passenger = passengerService.getPassengerById(passengerId);
        passengerService.signUpForActivity(passenger, activity);
    }



    // Create a new activity
    @PostMapping("/create")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    // Get all activities
    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    // Get available activities
    @GetMapping("/available")
    public List<Activity> getAvailableActivities() {
        return activityService.getAvailableActivities();
    }

    // Get activity by ID
    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    // Update activity
    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    // Delete activity
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}




