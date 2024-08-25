package org.buildcode;

import org.buildcode.state.NoMoneyInsertedState;
import org.buildcode.state.State;

import java.util.List;

public class VendingMachine {
    private State state;
    private  double collectedAmount;
    private int numOfRacks;
    private List<Rack> racks;
    private List<Integer> availableRacks;

    private static VendingMachine INSTANCE = null;

    private VendingMachine(){
        state = new NoMoneyInsertedState();
        this.collectedAmount = 0;
    }

    public static VendingMachine getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new VendingMachine();
        }
        return INSTANCE;
    }

    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public void collectMoney(double amount) {
        this.collectedAmount += amount;
    }

    public void insertMoney(double amount) {
        this.state.insertedMoney(this, amount);
    }

    public void pressButton(int rackNumber) {
        this.state.pressButton(this, rackNumber);

        double someReturnAmount = 1.0;

        this.returnChange(someReturnAmount);

        this.updateInventory(rackNumber);
    }

    private void returnChange(double amount) {
        this.state.returnChange(amount);
    }

    private void updateInventory(int rackNumber) {
        this.state.updateInventory(this, rackNumber);
    }

    public void dispenseProduct(int rackNumber) {
        this.state.dispenseProduct(this, rackNumber);
    }
}