package com.group14.billetsystem.travel;

import com.group14.billetsystem.Devices.UserBilletDevice;

public class UserTravel {
    private final UserBilletDevice user;
    private int numberOfStops = 0;

    public UserTravel(UserBilletDevice user) {
        this.user = user;
    }

    public void incrementStopCounter(){
        numberOfStops++;
    }

    public int getNumberOfStops(){
        return numberOfStops;
    }

    public UserBilletDevice getUser() {
        return user;
    }
}
