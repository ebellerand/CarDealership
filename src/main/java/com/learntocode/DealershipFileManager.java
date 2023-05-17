package com.learntocode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private static final String filename = "dealership.csv";
    Dealership dealership = null;

    public Dealership getDealershipFromCsv(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String name = data[0].trim();
                String address = data[1].trim();
                String phone = data[2].trim();
                dealership = new Dealership(name, address, phone, new ArrayList<>());

                processVehicleData(reader, dealership);

            }
        } catch (IOException e) {
            System.out.println("Error reading dealership file. ");
        }
        if (dealership != null) {
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Failed to create dealership object.");
            return null;
        }
        return dealership;
    }

    private void processVehicleData(BufferedReader reader, Dealership dealership) throws IOException {
        String line;
       // boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {
          /*  if (isFirstLine) {
                isFirstLine = false;
                continue;
            } */

            String[] data = line.split("\\|");
            int vin = Integer.parseInt(data[0].trim());
            int year = Integer.parseInt(data[1].trim());
            String make = data[2].trim();
            String model = data[3].trim();
            String vehicleType = data[4].trim();
            String color = data[5].trim();
            int odometer = Integer.parseInt(data[6].trim());
            double price = Double.parseDouble(data[7].trim());

            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(vehicle);

        }
    }

    public void writeCsvFileToAddVehicle(List<Vehicle> inventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
           /*  String dealershipLine = dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone();
            writer.write(dealershipLine);
            writer.newLine();
*/
            for (Vehicle vehicle : inventory) {
                String line = vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDealership() {


    }
}


