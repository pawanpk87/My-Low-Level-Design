package org.buildcode.model;

import org.buildcode.ATM;
import org.buildcode.enums.TransactionType;

public class CheckBalanceState extends ATMState {
    private final ATM atm;

    public CheckBalanceState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(ATMCard card) {
        throw new UnsupportedOperationException("Card is already insert!");
    }

    @Override
    public void authenticatePint(String pin) {
        throw new UnsupportedOperationException("Pin is already authenticated, Please select an option!");
    }

    @Override
    public void selectOperation(TransactionType transactionType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cashWithdrawal(int withdrawalAmount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayBalance() {
        // display balance
    }

    @Override
    public void transferMoney(String accountNumber, double transferAmount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void returnCard() {
        atm.setCurrState(new IdleState(atm));
    }

    @Override
    public void exit() {
        atm.setCurrState(new IdleState(atm));
    }
}
