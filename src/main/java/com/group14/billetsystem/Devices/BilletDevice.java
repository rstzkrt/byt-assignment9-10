package com.group14.billetsystem.Devices;

import com.group14.billetsystem.Vehicle.Vehicle;
import com.group14.billetsystem.travel.TravelHistory;
import com.group14.billetsystem.travel.UserTravel;

import javax.sound.midi.Track;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BilletDevice {
    private int id;

    private final Vehicle vehicle;

    private final Set<UserTravel> presentDevices = new HashSet<>();

    private final Set<UserTravel> devicesThatLeft = new HashSet<>();

    private TravelHistory travelHistory;

    public BilletDevice(int id, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void scanDevices(){
        System.out.println("devices area scanning");
    }

    public void incrementStopCounter(){
        presentDevices.forEach(UserTravel::incrementStopCounter);
    }

    public boolean detectDoorsBlocked(){
        return true;
    }

    public Set<UserTravel> getDevicesThatLeft(){
        return Collections.unmodifiableSet(devicesThatLeft);
    }

    public int calculateStopsTravelled(){
        return 10;
    }

}
