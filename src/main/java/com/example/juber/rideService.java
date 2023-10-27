package com.example.juber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class RideService {
    private Connection connection;

    public RideService() {
        try {
            // Initialize the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servicetaker", "userName", "userPass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<Driver> availableDrivers = new ArrayList<>();
    List<Ride> activeRides = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    private Location salamBarkatHall = new Location(37.7732, -122.4219);
    private Location roffiqJabbarHall = new Location(37.7755, -122.4212);
    private Location cseDepartment = new Location(37.7737, -122.4197);
    private Scanner scanner = new Scanner(System.in);

    public void loadData() {
        // Load user data from the database and populate the users map
        // Example SQL query: "SELECT username, password, account_balance FROM users"
        // Execute the query and populate the users map
    }

    public void saveData() {
        // Save user data to the database
        // Example SQL query: "UPDATE users SET account_balance = ? WHERE username = ?"
        // Execute the query for each user in the users map
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password);
            users.put(username, newUser);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public User loginUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.password.equals(password)) {
                System.out.println("Login successful.");
                return user;
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Username not found.");
        }
        return null;
    }

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    public void requestRide(Rider rider, User loggedInUser) {
        // Your ride request logic here
    }

    private double calculateRideDistance(List<Location> path) {
        // Calculate ride distance based on the path
        return 0.0;
    }

    private double calculateRideCharge(double distance) {
        // Calculate ride charge based on distance
        return distance * 0.1;
    }
}