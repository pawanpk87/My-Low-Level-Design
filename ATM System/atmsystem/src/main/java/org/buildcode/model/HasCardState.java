package org.buildcode.model;

import org.buildcode.ATM;
import org.buildcode.Bank;
import org.buildcode.enums.TransactionType;


public class HasCardState extends ATMState {
    private final ATM atm;

    public HasCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(ATMCard card) {
        throw new UnsupportedOperationException("Card is already insert!");
    }

    @Override
    public void authenticatePint(String pin) {
        if(Bank.getInstance().findBankAccountByCardNumber(atm.getAtmCard().getCardNumber()).validatePin(pin)) {
            System.out.println("Pin validated successfully!");
            atm.setCurrState(new SelectOperationState());
        } else {
            System.out.println("Invalid Pin!");
            atm.setCurrState(new IdleState(atm));
        }
    }

    @Override
    public void selectOperation(TransactionType transactionType) {
        throw new UnsupportedOperationException("Please authenticate pin first!");
    }

    @Override
    public void cashWithdrawal(int withdrawalAmount) {
        throw new UnsupportedOperationException("Please authenticate pin first!");
    }

    @Override
    public void displayBalance() {
        throw new UnsupportedOperationException("Please authenticate pin first!");
    }

    @Override
    public void transferMoney(String accountNumber, double transferAmount) {
        throw new UnsupportedOperationException("Please authenticate pin first!");
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