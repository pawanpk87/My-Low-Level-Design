package org.buildcode.model;

public class SavingAccount extends BankAccount {
    private final double WITHDRAW_LIMIT = 1200.0;

    public double withdrawLimit() {
        return WITHDRAW_LIMIT;
    }
}
