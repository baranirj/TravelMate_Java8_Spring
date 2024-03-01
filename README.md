### Travel Agency Software System

This repository contains a software system designed for travel agencies to manage travel packages, itineraries, and passengers. The system is implemented in Java using the Spring framework, JPA for persistence, and MySQL as the backend database.

#### Features:

- **TravelPackage**: Represents a travel package with a name, passenger capacity, itinerary, and list of passengers.
- **Destination**: Represents a destination with a name and a list of activities available.
- **Activity**: Represents an activity with a name, description, cost, capacity, and destination.
- **Passenger**: Represents a passenger with a name, passenger number, type, balance, and list of activities signed up.

#### Functionality:

1. **Print Itinerary**: View details of destinations and available activities in a travel package.
2. **Print Passenger List**: See the list of passengers enrolled in a travel package.
3. **Print Individual Passenger Details**: Get details of a specific passenger including signed-up activities.
4. **Print Available Activities**: See activities with available space for enrollment.
5. **Add/Remove Passengers**: Allows the travel agency to add or remove passengers from a travel package.
6. **Enroll/Cancel Activities**: Enables passengers to enroll in or cancel activities within a travel package.
7. **Calculate Discounts**: Automatically calculates discounts for gold passengers based on their activity sign-ups.
8. **Manage Passenger Balances**: Tracks and updates passenger balances for standard and gold passengers.
9. **View Occupancy**: Displays the current occupancy level of each activity to ensure efficient resource allocation.
10. **Search Passengers**: Allows searching for passengers by name or passenger number for quick access to their details.
11. **Update Activity Details**: Provides functionality to update activity details such as cost, description, or capacity.
12. **Generate Reports**: Generates reports on passenger activity sign-ups, revenue generated, and overall package utilization.

#### Setup Instructions:

1. Clone the repository.
2. Configure MySQL database connection in `application.properties`.
3. Run the application using Spring Boot.

#### Testing:

- Unit tests are provided for each class and method to ensure correctness and reliability.


#### License:

This project is licensed under the [MIT License](link).
