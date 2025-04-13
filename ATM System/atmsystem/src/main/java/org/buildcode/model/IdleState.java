package org.buildcode.model;

import org.buildcode.ATM;
import org.buildcode.enums.TransactionType;

public class IdleState extends ATMState {
    private final ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(ATMCard card) {
        System.out.println("Inserting a card...");
        atm.setAtmCard(card);
        atm.setCurrState(new HasCardState(atm));
    }

    @Override
    public void authenticatePint(String pint) {
        throw new UnsupportedOperationException("Please insert card first!");
    }

    @Override
    public void selectOperation(TransactionType transactionType) {
        throw new UnsupportedOperationException("Please insert card first!");
    }

    @Override
    public void cashWithdrawal(int withdrawalAmount) {
        throw new UnsupportedOperationException("Please insert card first!");
    }

    @Override
    public void displayBalance() {
        throw new UnsupportedOperationException("Please insert card first!");
    }

    @Override
    public void transferMoney(String accountNumber, double transferAmount) {
        throw new UnsupportedOperationException("Please insert card first!");
    }

    @Override
    public void returnCard() {
        throw new UnsupportedOperationException("No card to return!");
    }

    @Override
    public void exit() {
        atm.setCurrState(new IdleState(atm));
    }

    public ATM getAtm() {
        return atm;
    }
}