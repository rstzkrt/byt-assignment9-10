package com.group14.billetsystem.payment.paymentMethods;

import com.group14.billetsystem.travel.UserTravel;

import java.math.BigInteger;

public class Payment {
    private final BigInteger amount;
    private final UserTravel travel;

    public Payment(UserTravel travel) {
        this.travel = travel;
        amount = calculateAmount(travel);
    }

    private BigInteger calculateAmount(UserTravel travel) {
        return BigInteger.ONE;
    }

}
