package org.buildcode;

import org.buildcode.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank INSTANCE = null;
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    private Bank() {

    }

    public static Bank getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Bank();
        }
        return INSTANCE;
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public BankAccount findBankAccountByCardNumber(String cardNumber) {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getCardNumber().equals(cardNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"));
    }
}