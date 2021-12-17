package com.group14.billetsystem.payment.paymentMethods;

import com.group14.billetsystem.travel.UserTravel;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Payment {
    private final BigInteger amount;
    private final UserTravel travel;

    //
    private Date paymentDate;
    private PaymentHistory paymentHistory;

    public Payment(UserTravel travel) {
        this.travel = travel;
        amount = calculateAmount(travel);
    }

    private BigInteger calculateAmount(UserTravel travel) {
        return BigInteger.ONE;
    }

}
