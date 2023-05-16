package com.learntocode;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        while (true) {
            try {
                DealershipFileManager dealershipFileManager = new DealershipFileManager();
                Dealership dealership = dealershipFileManager.getDealershipFromCsv("dealership.csv");

                if (dealership != null) {
                    UserInterface userInterface = new UserInterface(dealership);
                    userInterface.display();
                }
            } catch (IOException e) {
                System.out.println("Error occurred while reading the CSV file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
