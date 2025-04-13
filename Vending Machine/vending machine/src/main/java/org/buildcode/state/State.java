package org.buildcode.state;

import org.buildcode.VendingMachine;

public interface State {
    void insertedMoney(VendingMachine machine, double amount);
    void pressButton(VendingMachine machine, int rackNumber);
    void returnChange(double amount);
    void updateInventory(VendingMachine machine, int rackNumber);
    void dispenseProduct(VendingMachine machine, int rackNumber);
}