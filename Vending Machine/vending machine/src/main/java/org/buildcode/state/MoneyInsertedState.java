package org.buildcode.state;

import org.buildcode.VendingMachine;

public class MoneyInsertedState implements State {
    @Override
    public void insertedMoney(VendingMachine machine, double amount) {
        throw new RuntimeException("Unable to insert money,(Money is already inserted!)");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("Selected the product (rackNumber: " + rackNumber + ")");
    }

    @Override
    public void returnChange(double amount) {
        System.out.println("Returning the change...");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("Updating the Inventory...");
        machine.setState(new DispenseState());
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Unable to dispense the product!");
    }
}
