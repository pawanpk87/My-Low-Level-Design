package org.buildcode;

import org.buildcode.model.BankAccount;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        bank.addBankAccount(
                new BankAccount("accountNumber", "cardNumber", 12.0)
        );

        ATM atm = ATM.getInstance();



    }
}