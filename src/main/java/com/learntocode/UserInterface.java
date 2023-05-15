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
        System.out.println("1 - Get by price. 2 - Get by make/model. 3 - Get by year. 4 - Get by color. 5 - Get by mileage. 6 - Get by vehicle type. 7 - Show all vehicles. INTERNAL: 8 - Add a vehicle. 9 - Remove a vehicle. ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter your selection: ");
        int command = scanner.nextInt();


        switch (command) {
            case 1:
                System.out.println("Enter minimum price: ");
                double minPrice = scanner.nextDouble();
                System.out.println("Enter maximum price: ");
                double maxPrice = scanner.nextDouble();
                List<Vehicle> vehiclesByPrice = dealership.getVehicleByPrice(minPrice, maxPrice);

        break;
        case 2:
            

        break;
        case 3:

        break;
        case 4:

        break;
        case 5:

        break;
        case 6:

        break;
        case 7:

        break;

        case 8:

        break;

        case 9:

        break;


        default:

                System.out.println("Invalid selection. Please try again. ");
                System.out.println("----------------------------------------");
        }
    }
}
