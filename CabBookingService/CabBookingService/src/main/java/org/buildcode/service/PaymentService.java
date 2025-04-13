package org.buildcode.service;

import org.buildcode.enums.PaymentType;
import org.buildcode.model.Payment;

import java.util.List;

public interface PaymentService {

    Boolean pay(Payment payment);

    PaymentType getType();

    public static PaymentService getService(PaymentType paymentType, List<PaymentService> paymentServices) {
        return paymentServices.stream()
                .filter(paymentService -> paymentService.getType().equals(paymentType))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("No Payment Service found for type: " + paymentType));
    }
}
