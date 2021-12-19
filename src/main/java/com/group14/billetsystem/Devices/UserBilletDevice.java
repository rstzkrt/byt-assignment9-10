package com.group14.billetsystem.Devices;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import com.group14.billetsystem.payment.paymentMethods.CreditCard;
import com.group14.billetsystem.travel.TravelHistory;

public class UserBilletDevice {
    private UUID id;
    private String type;
    private double price;

    //
    private TravelHistory travelHistory;

    public TravelHistory getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(TravelHistory travelHistory) {
        this.travelHistory = travelHistory;
    }

    public UserBilletDevice() {
    }

    public UserBilletDevice(String type, double price) {
    	this.id = UUID.randomUUID();
        this.type = type;
        this.price = price;
    }

    public UUID getId() {
        return id;
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
    
    
    public static Optional<UserBilletDevice> createUBD(String type,  double price) {
		if (validateType(type) && validatePrice(price) ){
            return Optional.of(new UserBilletDevice(type, price));
        }
        return Optional.empty();		
	}
	
	 private static boolean validateType(String type){
	        return type != null && type.matches("[A-Z][a-z]{2,20}");
	    }

	   
	  

	    private static boolean validatePrice(double price){
	        return price >10;
	    }
}
