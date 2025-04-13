package org.buildcode.state;

import org.buildcode.VendingMachine;

public class NoMoneyInsertedState implements State {
    @Override
    public void insertedMoney(VendingMachine machine, double amount) {
        System.out.println("Inserting the amount...");
        machine.collectMoney(amount);
        machine.setState(new MoneyInsertedState());
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        throw new RuntimeException("Unable to press the button (Money is not inserted!)");
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
        throw new RuntimeException("Unable to dispense product!");
    }
}
