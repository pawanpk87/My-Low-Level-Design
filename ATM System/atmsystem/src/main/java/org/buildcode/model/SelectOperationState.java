package org.buildcode.model;

import org.buildcode.ATM;
import org.buildcode.enums.TransactionType;

public class SelectOperationState extends ATMState {
    private final ATM atm;

    public SelectOperationState(ATM atm) {
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
        throw new UnsupportedOperationException("Please authenticate pin first!");
    }

    @Override
    public void cashWithdrawal(int withdrawalAmount) {
        throw new UnsupportedOperationException("Please select Cash Withdrawal option!");
    }

    @Override
    public void displayBalance() {
        throw new UnsupportedOperationException("Please select Display Balance option!");
    }

    @Override
    public void transferMoney(String accountNumber, double transferAmount) {
        throw new UnsupportedOperationException("Please select Transfer Money option!");
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
