package com.learntocode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    String filename = "dealership.csv";
    Dealership dealership = null;
    public void readCsvFile(String filename) throws IOException {
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
            }
        }
    private void processVehicleData(BufferedReader reader, Dealership dealership) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
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
        public void writeCsvFile(List<Vehicle> inventory) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Vehicle vehicle : dealership.getInventory()) {
                    String line = vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
