package org.buildcode.model;

import org.buildcode.enums.TransactionType;

public abstract class ATMState {
    public abstract void insertCard(ATMCard card);

    public abstract void authenticatePint(String pint);

    public abstract void selectOperation(TransactionType transactionType);

    public abstract void cashWithdrawal(int withdrawalAmount);

    public abstract void displayBalance();

    public abstract void transferMoney(String accountNumber, double transferAmount);

    public abstract void returnCard();

    public abstract void exit();
}