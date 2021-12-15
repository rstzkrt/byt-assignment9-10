package com.group14.billetsystem.payment.paymentMethods;

import java.time.LocalDate;

public class CreditCard extends PaymentMethod {
    private final String cardNumber;
    private final String cvcCode;
    private final LocalDate expirationDate;

    public CreditCard(String cardNumber, String cvcCode, LocalDate expirationDate) {
        this.cardNumber = cardNumber;
        this.cvcCode = cvcCode;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean pay() {
        return true;
    }
}
