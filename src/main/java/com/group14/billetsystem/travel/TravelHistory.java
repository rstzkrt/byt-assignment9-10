package com.group14.billetsystem.travel;

import com.group14.billetsystem.payment.paymentMethods.Payment;

import java.util.List;

public class TravelHistory {
    private List<Stops> stopsList;

    public TravelHistory(List<Stops> stopsList) {
        this.stopsList = stopsList;
    }

    public List<Stops> getStopsList() {
        return stopsList;
    }

    public void setStopsList(List<Stops> stopsList) {
        this.stopsList = stopsList;
    }

    public void sendTravelReport(){
        System.out.println("Report is loading...");
        for (Stops s:stopsList){
            System.out.println(s.name());
        }
    }
}
