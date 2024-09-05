package org.buildcode.service;

import org.buildcode.enums.PaymentType;
import org.buildcode.model.Payment;

public class CashPaymentService implements PaymentService {
    @Override
    public Boolean pay(Payment payment) {
        // cash payment
        return null;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }
}
