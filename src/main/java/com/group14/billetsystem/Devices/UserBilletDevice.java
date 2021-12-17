package com.group14.billetsystem.Devices;

import com.group14.billetsystem.travel.TravelHistory;

public class UserBilletDevice {
    private int id;
    private String type;
    private double price;

    //
    private TravelHistory travelHistory;

    public UserBilletDevice() {
    }

    public UserBilletDevice(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
