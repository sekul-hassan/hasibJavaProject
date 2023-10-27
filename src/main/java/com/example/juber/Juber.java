package com.example.juber;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Location {
    double latitude;
    double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class User {
    String username;
    String password;
    double accountBalance=100;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accountBalance = 100;
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Driver {
    String name;
    Location location;

    public Driver(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}

class Rider {
    String name;
    Location location;

    public Rider(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void requestRide(Location newLocation) {
        System.out.println(name + " is requesting a ride to the selected location.");

        location = newLocation;
    }
}

class Ride {
    Rider rider;
    Driver driver;
    boolean rideStarted;

    public Ride(Rider rider, Driver driver) {
        this.rider = rider;
        this.driver = driver;
        this.rideStarted = false; 
    }

    public void startRide() {
        if (!rideStarted) {
            System.out.println("Ride started.");
            rideStarted = true;
        } else {
            System.out.println("Ride is already started.");
        }
    }

    public void endRide() {
        if (rideStarted) {
            System.out.println("Ride ended.");
            rideStarted = false;
        } else {
            System.out.println("Ride hasn't started yet.");
        }
    }
}

class MapService {
    public static double calculateDistance(Location location1, Location location2) {

        return Math.sqrt(Math.pow(location1.latitude - location2.latitude, 2)
                + Math.pow(location1.longitude - location2.longitude, 2));
    }

    public static List<Location> getShortestPath(Location start, Location end) {

        List<Location> shortestPath = new ArrayList<>();
       
        return shortestPath;
    }
}



public class Juber {
    
    public static void main(String[] args) {
        
        
/*JFrame frame = new Jframe();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JUBER");
        frame.setVisible(true);
        frame.setSize(420,420);*/
               // ImageIcon image =new ImageIcon("logo.jpg");
               Frontpage frontpage= new Frontpage();
              frontpage.setVisible(true);
              frontpage.pack();
        RideService rideService = new RideService();
        Scanner scanner = new Scanner(System.in);

        rideService.loadData();
        Driver driver1 = new Driver("John", new Location(37.7749, -122.4194));
        rideService.addDriver(driver1);

        int choice = 0;
        while (choice != 3) {
            System.out.println("Welcome to Juber!");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Finish");
          

              choice = scanner.nextInt();
              
              
            if (choice == 1) {
                
                System.out.print("Enter your username: ");
                String signUpUsername = scanner.next();
                System.out.print("Enter your password: ");
                String signUpPassword = scanner.next();
                rideService.registerUser(signUpUsername, signUpPassword);
                rideService.saveData();
            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String loginUsername = scanner.next();
                System.out.print("Enter your password: ");
                String loginPassword = scanner.next();
                User loggedInUser = rideService.loginUser(loginUsername, loginPassword);

                if (loggedInUser != null) {
                    Rider rider1 = new Rider("Alice", new Location(37.7749, -122.4194));
                    rideService.requestRide(rider1, loggedInUser);

                    
                    Ride ride = rideService.activeRides.get(0);
                    ride.startRide();
                    loggedInUser.accountBalance-=10;
                    ride.endRide();
int ch;
System.out.print("Payment Option :\n1.Bkash\n2.Nagad\n");
ch = scanner.nextInt();



                    System.out.println("Remaining account balance: $" + loggedInUser.accountBalance);
                    System.out.print("Do you Want To Quite!\n1.YES\n2.NO");
                   int c;
                    c = scanner.nextInt();
                    if(c==1)
                    {
                        System.out.print("Thank You For using JUBER");
                        //break;
                        
                       
                    }
                    
                }
            }
        }
        
    }
}
