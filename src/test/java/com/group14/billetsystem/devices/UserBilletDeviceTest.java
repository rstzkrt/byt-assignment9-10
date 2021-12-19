package com.group14.billetsystem.devices;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.group14.billetsystem.Devices.UserBilletDevice;

class UserBilletDeviceTest {
	private static final String type = "Type";
	private static final double price = 44.6;
	

	@Test
	public void shouldCreateUserBD() {
		Optional<UserBilletDevice> ubd = UserBilletDevice.createUBD(type, price);
        assertTrue(ubd.isPresent());
        UserBilletDevice userbd = ubd.get();
        assertEquals(userbd.getType(), type);
        assertEquals(userbd.getPrice(), price);
 
	}
	
	@Test
	public void shouldNotCreateUserBDWithBadType() {
		String nullType = null;
        Optional<UserBilletDevice> ubd = createDeviceWithCustomType(nullType);
        assertFalse(ubd.isPresent());

        String emptyType = "";
        ubd = createDeviceWithCustomType(emptyType);
        assertFalse(ubd.isPresent());

        String badLetters = "ęąĄĘ";
        ubd = createDeviceWithCustomType(badLetters);
        assertFalse(ubd.isPresent());

        String toShort = "H";
        ubd = createDeviceWithCustomType(toShort);
        assertFalse(ubd.isPresent());

        String toLong = "Omgiwanttosleepeverywhereandallthetime";
        ubd = createDeviceWithCustomType(toLong);
        assertFalse(ubd.isPresent());

        String smallFirstLetter = "test";
        ubd = createDeviceWithCustomType(smallFirstLetter);
        assertFalse(ubd.isPresent());
        
        String notLetters = "^[0-9]";
        ubd = createDeviceWithCustomType(notLetters);
        assertFalse(ubd.isPresent());
        
	}
	
	
	@Test
	public void shouldNotCreateUserDBWithBadPrice() {
		Double zeroPrice = 0.0;
        Optional<UserBilletDevice> ubd = createDeviceWithCustomPrice(zeroPrice);
        assertFalse(ubd.isPresent());
        
        Double tooSmallPrice=4.0;
        ubd = createDeviceWithCustomPrice(tooSmallPrice);
        if(tooSmallPrice<10.0) {
            assertFalse(ubd.isPresent());

        }
        
        Double tooBigPrice=20000.0;
        ubd = createDeviceWithCustomPrice(tooSmallPrice);
        if(tooBigPrice>1000.0) {
            assertFalse(ubd.isPresent());

        }
       
		
	}
	

	private Optional<UserBilletDevice> createDeviceWithCustomPrice(Double zeroPrice) {
		return UserBilletDevice.createUBD(type, zeroPrice);
	}

	private Optional<UserBilletDevice> createDeviceWithCustomType(String nullType) {
		return UserBilletDevice.createUBD(nullType, price);
	}

}
