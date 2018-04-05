package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.BannedUserException;
import exception.HostException;
import exception.LoggedException;
import system.Application;
import user.*;

public class ApplicationTest {

	@Test
	public void testGetApplication() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		assertNotNull(app);
	}

	@Test
	public void testLoginUser() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
		} catch (LoggedException | BannedUserException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testLoginAdmin() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		Admin admin = null;
		try {
			admin = app.loginAdmin("ImTheMdfkAdmin", "OpenBalls");
			assertNotNull(admin);
		} catch (LoggedException e) {
			fail("Someone logged");
		}
	}

	@Test
	public void testAddUser() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
		} catch (LoggedException | BannedUserException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testAddHouse() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addHouse("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
			assertEquals(1,app.getHostHouses(user).size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testGetHostHouses() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addHouse("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
			assertEquals(1,app.getHostHouses(user).size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testAddOfferLiving() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOfferVacational() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHostOffers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGuestOffers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminOffers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferZip() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferReserved() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchOfferBought() {
		fail("Not yet implemented");
	}

}
