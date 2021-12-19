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

}
