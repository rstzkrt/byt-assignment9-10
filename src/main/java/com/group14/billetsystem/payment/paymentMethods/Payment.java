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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public Payment(UserTravel travel) {
        this.travel = travel;
        amount = calculateAmount(travel);
    }

    private BigInteger calculateAmount(UserTravel travel) {
        return BigInteger.ONE;
    }

}
