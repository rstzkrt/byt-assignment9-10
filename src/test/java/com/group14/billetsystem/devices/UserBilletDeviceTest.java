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
	}

	private Optional<UserBilletDevice> createDeviceWithCustomType(String nullType) {
		return UserBilletDevice.createUBD(nullType, price);
	}

}
