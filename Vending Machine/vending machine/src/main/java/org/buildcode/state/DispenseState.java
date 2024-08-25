package org.buildcode.state;

import org.buildcode.VendingMachine;

public class DispenseState implements State {
    @Override
    public void insertedMoney(VendingMachine machine, double amount) {
        throw new RuntimeException("Unable to insert money,(Money is already inserted!)");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        throw new RuntimeException("Unable to press the button!");
    }

    @Override
    public void returnChange(double amount) {
        throw new RuntimeException("Unable to return change!");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        throw new RuntimeException("Unable to update inventory!");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Dispensing product...");
        machine.setState(new NoMoneyInsertedState());
    }
}
