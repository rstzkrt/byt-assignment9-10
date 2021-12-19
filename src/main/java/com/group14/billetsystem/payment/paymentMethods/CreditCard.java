package com.group14.billetsystem.payment.paymentMethods;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import com.group14.billetsystem.user.Email;
import com.group14.billetsystem.user.User;

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

	public static Optional<CreditCard> AddCC(String cardNumber, String cvcCode, LocalDate expirationDate) {
		if (validateNumberCC(cardNumber) && validateCVC(cvcCode) && validateDate(expirationDate)){
            return Optional.of(new CreditCard(cardNumber,cvcCode,expirationDate));
        }
        return Optional.empty();		
	}
	
	 private static boolean validateNumberCC(String cardNumber){
	        return cardNumber != null && cardNumber.matches("(?<=^|[^0-9])[0-9]{16}(?=[^0-9]|$)|[0-9]{4}[-| |_][0-9]{4}[-| |_][0-9]{4}[-| |_][0-9]{4}");
	    }

	   
	    private static boolean validateDate(LocalDate expirationDate){
	    	return  expirationDate.isAfter(LocalDate.now());
	        
	    }


	    private static boolean validateCVC(String cvcCode){
	        return cvcCode != null && cvcCode.matches("(^[0-9]{3}$)");
	    }
}
