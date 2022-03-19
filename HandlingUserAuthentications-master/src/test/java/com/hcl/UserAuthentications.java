package com.hcl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserAuthentications {

	@BeforeEach
	public void setup() {

		UserAuthentication.seedData();
	}

	@Test
	public void testLogin() {

		UserAuthentication authentication = new UserAuthentication();

		assertEquals(true, authentication.login("kush2", "pass2"));

	}

	@Test
	public void testWrongUser() {

		UserAuthentication authentication = new UserAuthentication();

		assertEquals(false, authentication.login("ABC", "pass"));

	}

	@Test
	public void testLogout() {

		UserAuthentication authentication = new UserAuthentication();

		assertEquals(true, authentication.login("kush", "pass"));
		authentication.logout();

	}

}
