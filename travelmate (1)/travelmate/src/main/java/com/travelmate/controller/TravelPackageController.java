package com.travelmate.controller;

import com.travelmate.model.Activity;
import com.travelmate.model.TravelPackage;
import com.travelmate.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @PostMapping("/create")
    public TravelPackage createTravelPackage(@RequestBody TravelPackage travelPackage) {
        return travelPackageService.createTravelPackage(travelPackage);
    }

    @PostMapping("/{packageId}/activities")
    public TravelPackage addActivityToPackage(@PathVariable Long packageId, @RequestBody Activity activity) {
        return travelPackageService.addActivityToPackage(packageId, activity);
    }

    @PostMapping("/{packageId}/passengers/{passengerId}/activities")
    public TravelPackage signUpPassengerForActivity(@PathVariable Long packageId, @PathVariable Long passengerId, @RequestBody Activity activity) {
        return travelPackageService.signUpPassengerForActivity(packageId, passengerId, activity);
    }

    @GetMapping("/{packageId}/itinerary")
    public void printItinerary(@PathVariable Long packageId) {
        travelPackageService.printItinerary(packageId);
    }

    @GetMapping("/{packageId}")
    public TravelPackage getTravelPackageById(@PathVariable Long packageId) {
        return travelPackageService.getTravelPackageById(packageId);
    }
}
