package com.learntocode;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    //Pass dealership object to the User Interface constructor
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;

    }
    public void display() {
        init();

        try {
          menuHelper();


        } catch (Exception e) {
            System.out.println("There was an error. ");
        }
    }

    private void init() {
        dealership = new Dealership(dealership.getName(), dealership.getAddress(), dealership.getPhone(), dealership.getInventory());
    }
    public void menuHelper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dealership. ");
        System.out.println("----------------------------");
        System.out.println("Please feel free to search our growing selection of vehicles.");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1 - Get by price. 2 - Get by make/model. 3 - Get by year. 4 - Get by color. 5 - Get by mileage. 6 - Get by vehicle type. 7 - Show all vehicles. INTERNAL: 8 - Add a vehicle. 9 - Remove a vehicle. 99- Exit. ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter your selection: ");
        int command = scanner.nextInt();
        scanner.nextLine();
        String password = "password";


        switch (command) {
            case 1:
                System.out.println("Enter minimum price: ");
                double minPrice = scanner.nextDouble();
                System.out.println("Enter maximum price: ");
                double maxPrice = scanner.nextDouble();
                List<Vehicle> vehiclesByPrice = dealership.getVehicleByPrice(minPrice, maxPrice);
                System.out.println("Vehicles within the price range: ");
                for (Vehicle vehicle : vehiclesByPrice) {
                    System.out.println(vehicle);
                    System.out.println("-------------------------------------");
                }
                break;

            case 2:
                scanner.nextLine();
                System.out.println("Enter make: ");
                String searchMake = scanner.nextLine();
                System.out.println("Enter model: ");
                String searchModel = scanner.nextLine();
                List<Vehicle> vehiclesByMakeModel = dealership.getVehicleByMakeModel(searchMake, searchModel);
                for (Vehicle vehicle : vehiclesByMakeModel) {
                    System.out.println(vehiclesByMakeModel);
                }
                break;

            case 3:
                System.out.println("Enter the year that starts the range: ");
                int searchStartYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the year that ends the range: ");
                int searchEndYear = scanner.nextInt();
                List<Vehicle> vehiclesByYear = dealership.getVehicleByYear(searchStartYear, searchEndYear);
                System.out.println("Vehicles within the year range: ");
                for (Vehicle vehicle : vehiclesByYear) {
                    System.out.println(vehicle);
                }
                break;

            case 4:
                System.out.println("Enter the color: ");
                String searchColor = scanner.nextLine();
                List<Vehicle> vehiclesByColor = dealership.getVehicleByColor(searchColor);
                for (Vehicle vehicle : vehiclesByColor) {
                    System.out.println(vehiclesByColor);
                }
               // System.out.println(vehiclesByColor);
                break;

            case 5:
                System.out.println("Enter the mileage minimum: ");
                int searchMileageMin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the mileage maximum: ");
                int searchMileageMax = scanner.nextInt();
                List<Vehicle> vehiclesByMileage = dealership.getVehicleByMileage(searchMileageMin, searchMileageMax);
                break;

            case 6:
                System.out.println("Enter the vehicle type: ");
                String searchVehicleType = scanner.nextLine();
                List<Vehicle> vehiclesByVehicleType = dealership.getVehicleByType(searchVehicleType);
                break;

            case 7:
                System.out.println("All vehicles: ");
                System.out.println("-----------------------------------------------------");
                List<Vehicle> allVehicles = dealership.getAllVehicles();
                for (Vehicle vehicle : allVehicles) {
                    System.out.println(vehicle);
                }
                break;

            case 8:
                System.out.println("Internal selection: Add a Vehicle");
                System.out.println("--------------------------------------------------------");
                System.out.println("Please enter the password: ");
                String enteredPassword = scanner.next();
                if (enteredPassword.equals("password")) {
                    System.out.println("Enter VIN: ");
                    int vin = scanner.nextInt();
                    System.out.println("Enter Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.println("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.println("Enter Vehicle Type: ");
                    String vehicleType = scanner.nextLine();
                    System.out.println("Enter Color: ");
                    String color = scanner.nextLine();
                    System.out.println("Enter Odometer: ");
                    int odometer = scanner.nextInt();
                    System.out.println("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                    DealershipFileManager fileManager = new DealershipFileManager();
                   // fileManager.writeCsvFile(dealership.getInventory());



                    System.out.println("Vehicle added successfully. ");

                } else {
                    System.out.println("Incorrect password. Access denied.");
                }
                break;

            case 9:
                System.out.println("Internal Selection: Remove a Vehicle");
                System.out.println("--------------------------------------------");
                System.out.println("Please enter the password: ");
                enteredPassword = scanner.next();
                if (enteredPassword.equals("password")) {
                    System.out.println("Enter the VIN of the vehicle to remove: ");
                    int vinToRemove = scanner.nextInt();
                    scanner.nextLine();
                    boolean isVehicleRemoved = dealership.removeVehicleByVin(vinToRemove);
                    if (isVehicleRemoved) {
                        System.out.println("Vehicle removed successfully. ");
                    } else {
                        System.out.println("Vehicle not found or removal failed. ");
                    }
                } else {
                    System.out.println("Incorrect password. Access denied.");
                }
                break;
            case 99:
                System.out.println("Exiting the program... ");
                System.out.println("Goodbye!");
                System.exit(0);
               break;

                default:

                System.out.println("Invalid selection. Please try again. ");
                System.out.println("----------------------------------------");
        }
    }
}
