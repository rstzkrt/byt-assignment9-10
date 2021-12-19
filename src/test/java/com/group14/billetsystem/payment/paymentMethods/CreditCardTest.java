package com.group14.billetsystem.payment.paymentMethods;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.group14.billetsystem.user.User;

class CreditCardTest {
	private static final String cardNumber = "0908199573662431";
	private static final String cvcCode = "125";
	private static final LocalDate expirationDate = LocalDate.of(2022, 8, 9);


	  @Test
	    public void shouldAddCC() {
		  Optional<CreditCard> cc = CreditCard.AddCC(cardNumber, cvcCode, expirationDate);
	        assertTrue(cc.isPresent());
	        CreditCard card1 = cc.get();
	        assertEquals(card1.getCardNumber(), cardNumber);
	        assertEquals(card1.getCvcCode(), cvcCode);
	        assertEquals(card1.getExpirationDate(), expirationDate);
	        
		  
	  }
	  
	  
	  @Test
	  	public void shouldNotAddCCWithBadNumber() {
		  String nullCardNumber = null;
		  Optional<CreditCard> cc = createCCwithCustomNumber(nullCardNumber);
	      assertFalse(cc.isPresent());
	      
	      String emptyNumber = "";
	      cc = createCCwithCustomNumber(emptyNumber);
	      assertFalse(cc.isPresent());

		  
		  String notNumbers = "/^[a-zA-Z]+$/g";
		  cc = createCCwithCustomNumber(nullCardNumber);
	       assertFalse(cc.isPresent());


		  
		  
	  }
	  
	  @Test
	  	public void shouldNotAddCCWithBadCVC() {
		  String nullCVC =null;
		  Optional<CreditCard> cc = createCCwithCustomCVC(nullCVC);
		  assertFalse(cc.isPresent());
		  
		  String emptyCVC ="";
		  cc = createCCwithCustomCVC(emptyCVC);
		  assertFalse(cc.isPresent());
		  
		  String notNumbers = "/^[a-zA-Z]+$/g";
		  cc = createCCwithCustomCVC(notNumbers);
		  assertFalse(cc.isPresent());


		  
		  		
		  
	  }
	  
	  
	  @Test
	  	public void shouldNotAddWithBadED() {
		  	LocalDate beforeNow = LocalDate.now().minus(3, ChronoUnit.YEARS);
	        Optional<CreditCard> cc = createCCwithCustomED(beforeNow);
	        assertFalse(cc.isPresent());
	        LocalDate now = LocalDate.now();
	        cc = createCCwithCustomED(now);
	        assertFalse(cc.isPresent());
		  
		  
	  }
	  
	 


	private Optional<CreditCard> createCCwithCustomED(LocalDate nullED) {
		return CreditCard.AddCC(cardNumber, cvcCode, nullED);
	}


	private Optional<CreditCard> createCCwithCustomCVC(String nullCVC) {
		return CreditCard.AddCC(cardNumber, nullCVC, expirationDate);
	}


	private Optional<CreditCard> createCCwithCustomNumber(String nullCardNumber) {

		return CreditCard.AddCC(nullCardNumber, cvcCode , expirationDate);
	}
	  
	  
	  
	  
	  
	  
}