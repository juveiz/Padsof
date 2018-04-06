package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.BannedUserException;
import exception.GuestException;
import exception.HostException;
import exception.LoggedException;
import exception.NonRegisteredException;
import system.Application;
import user.*;
import offer.*;

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
		Application app = Application.getApplication("Eva", "Touris","OpenBalls");
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
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.searchOfferType("Living").size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testAddOfferVacational() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferVacational(LocalDate.now(), 100, house, LocalDate.now().plusDays(3));
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.searchOfferType("Vacational").size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testGetHostOffers() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferVacational(LocalDate.now(), 100, house, LocalDate.now().plusDays(3));
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.getHostOffers(user).size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testGetGuestOffers() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferVacational(LocalDate.now(), 100, house, LocalDate.now().plusDays(3));
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(0,app.getGuestOffers(user).size());
		} catch (LoggedException | BannedUserException | HostException | GuestException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testGetAdminOffers() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferVacational(LocalDate.now(), 100, house, LocalDate.now().plusDays(3));
			user.setState(0);
			app.loginAdmin("ImTheMdfkAdmin", "OpenBalls");
			assertEquals(1,app.getAdminOffers().size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testSearchOfferType() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.searchOfferType("Living").size());
			app.addOfferVacational(LocalDate.now(), 100, house, LocalDate.now().plusDays(3));
			app.getHostOffers(user).get(1).setState(1);
			assertEquals(1,app.searchOfferType("Vacational").size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
		
	}

	@Test
	public void testSearchOfferZip() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.searchOfferZip(28903).size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testSearchOfferDate() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(1,app.searchOfferDate(LocalDate.now().minusDays(10),LocalDate.now().plusDays(10)).size());
		} catch (LoggedException | BannedUserException | HostException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testSearchOfferRate() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(1);
			assertEquals(0,app.searchOfferRate(3).size());
		} catch (LoggedException | BannedUserException | HostException | NonRegisteredException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testSearchOfferReserved() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(3);
			assertEquals(1,app.searchOfferReserved().size());
		} catch (LoggedException | BannedUserException | HostException | NonRegisteredException e) {
			fail("Can't loggin");
		}
	}

	@Test
	public void testSearchOfferBought() {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = new House ("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		app.addUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		try {
			user = app.loginUser("1", "Wololo");
			assertNotNull(user);
			app.addOfferLiving(LocalDate.now(), 200, house, 3);
			app.getHostOffers(user).get(0).setState(4);
			assertEquals(1,app.searchOfferBought().size());
		} catch (LoggedException | BannedUserException | HostException | NonRegisteredException e) {
			fail("Can't loggin");
		}
	}

}
