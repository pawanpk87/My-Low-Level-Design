package org.buildcode;

import org.buildcode.enums.TransactionType;
import org.buildcode.model.ATMCard;
import org.buildcode.model.ATMState;
import org.buildcode.model.IdleState;

public class ATM {
    private static  ATM INSTANCE = null;
    private ATMState currState = null;
    private ATMCard atmCard = null;

    public ATM() {
        currState = new IdleState(this);
    }

    public static ATM getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ATM();
        }
        return INSTANCE;
    }

    public void setCurrState(ATMState state) {
        this.currState = state;
    }

    public void setAtmCard(ATMCard atmCard) {
        this.atmCard = atmCard;
    }

    public ATMCard getAtmCard() {
        return this.atmCard;
    }

    public void insertCard(ATMCard card) {
        currState.insertCard(card);
    }

    public void authenticatePint(String pin) {
        currState.authenticatePint(pin);
    }

    public void selectOperation(TransactionType transactionType) {
        currState.selectOperation(transactionType);
    }

    public void cashWithdrawal(int withdrawalAmount) {
        currState.cashWithdrawal(withdrawalAmount);
    }

    public void displayBalance() {
        currState.displayBalance();
    }

    public void transferMoney(String accountNumber, double transferAmount) {
        currState.transferMoney(accountNumber, transferAmount);
    }

    public void returnCard() {
        currState.returnCard();
    }

    public void exit() {
        currState.exit();
    }
}