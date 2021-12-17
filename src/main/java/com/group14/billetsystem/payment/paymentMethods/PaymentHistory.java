package com.group14.billetsystem.payment.paymentMethods;

import java.util.List;

public class PaymentHistory {
    private List<Payment> paymentList;

    public PaymentHistory(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public void sendReport(){
        System.out.println("Report is loading...");
        for (Payment p:paymentList){
            System.out.println(p.toString());
        }
    }
}
