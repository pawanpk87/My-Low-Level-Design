package org.buildcode.model;

public class BankAccount {
    private final String accountNumber;
    private final String cardNumber;
    private double totalBalance;

    public BankAccount(String accountNumber, String cardNumber, double totalBalance) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.totalBalance = totalBalance;
    }

    public double getAvailableBalance() {
        return this.totalBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public boolean validatePin(String pin) {
        // validate pin
        return true;
    }

    public void withdraw(double amount) {
        if(amount <= totalBalance){
            totalBalance = totalBalance - amount;
        }
    }
}