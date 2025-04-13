package org.buildcode.model;

public class ATMCard {
    private String cardNumber;
    private String customerName;
    private String cardExpiryDate;
    private String privatePin;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public String getPrivatePin() {
        return privatePin;
    }
}