package org.buildcode.service;

import org.buildcode.enums.PaymentType;
import org.buildcode.model.Payment;

public class CardPaymentService implements PaymentService {
    @Override
    public Boolean pay(Payment payment) {
        // card payment
        return null;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}
