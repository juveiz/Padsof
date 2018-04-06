package junit;

import static org.junit.Assert.*;

import org.junit.*;

import exception.*;
import user.Admin;
import user.RegisteredUser;

public class RegisteredUserTest {

	@Test
	public void testRegisteredUser() {
		assertNotNull(new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false));
	}

	@Test
	public void testGetName() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals("Paco", u.getName());
	}

	@Test
	public void testGetSurename() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals("Sanchez", u.getSurename());
	}

	@Test
	public void testGetId() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals("1", u.getId());
	}

	@Test
	public void testGetPassword() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals("Wololo", u.getPassword());
	}

	@Test
	public void testGetCreditCard() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals("1234a1234", u.getCreditCard());
	}

	@Test
	public void testGetState() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertEquals(0, u.getState());
	}

	@Test
	public void testSetState() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		u.setState(1);
		assertEquals(1, u.getState());
	}

	@Test
	public void testIsGuest() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		assertTrue(u.isGuest());
		u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", false, false);
		assertFalse(u.isGuest());
	}

	@Test
	public void testIsHost() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		assertTrue(u.isHost());
		u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", false, false);
		assertFalse(u.isHost());
	}

	@Test
	public void testGetGuest() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		try {
			assertNotNull(u.getGuest());
		} catch (GuestException e) {
			fail("Don't work");
		}
		u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", false, false);
		try {
			assertNotNull(u.getGuest());
			fail("Don't work");
		} catch (GuestException e) {
			assertNotNull(e);
		}

	}

	@Test
	public void testGetHost() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			assertNotNull(u.getHost());
		} catch (HostException e) {
			fail("Don't work");
		}
		u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", false, false);
		try {
			assertNotNull(u.getHost());
			fail("Don't work");
		} catch (HostException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testBanUser() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		u.banUser();
		assertEquals(-1, u.getState());
	}

	@Test
	public void testUnbanUser() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, false);
		u.banUser();
		u.unbanUser("4321b4321", new Admin("wolo", "wololo", "wolololooo", "megawololo"));
		assertEquals(0, u.getState());
		assertEquals("4321b4321", u.getCreditCard());

	}

}
