package com.learntocode;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private static DealershipFileManager fileManager = new DealershipFileManager();

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> vehiclesInPriceRange = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {
                vehiclesInPriceRange.add(vehicle);
            }
        }
        return vehiclesInPriceRange;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehicleByYear(int min, int max) {
        List<Vehicle> vehiclesInYearRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            int year = vehicle.getYear();
            if (year >= min && year <= max) {
                vehiclesInYearRange.add(vehicle);
            }
        }
        return vehiclesInYearRange;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        List<Vehicle> matchingColorVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (color.equalsIgnoreCase(vehicle.getColor())) {
                matchingColorVehicles.add(vehicle);
            }
        }
        return matchingColorVehicles;

    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return null;
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            allVehicles.add(inventory.get(i));
        }
        return allVehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
       //fileManager.writeCsvFile(inventory);

    }

    public boolean removeVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                inventory.remove(vehicle);
              //  fileManager.writeCsvFile(inventory);
                return true;
            }
        }
        return false;
    }
}
