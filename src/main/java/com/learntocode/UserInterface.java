package com.learntocode;

public class UserInterface {
    private Dealership dealership;
    public void display() {
        init();
    }

    private void init() {
        dealership = new Dealership(dealership.getName(), dealership.getAddress(), dealership.getPhone(), dealership.getInventory());
    }
}
