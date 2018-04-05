package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.HostException;
import offer.House;
import offer.Living;
import offer.ModifiableDate;
import offer.Offer;
import user.Host;
import user.RegisteredUser;

public class HostTest {

	@Test
	public void testAddOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		Host guest = new Host();
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			guest.addOffer(offer);
			assertEquals(1, guest.getOffers().size());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testAddHouse() {
		Host guest = new Host();
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		guest.addHouse(house);
		assertEquals(1, guest.getHouses().size());
	}

	@Test
	public void testRemoveOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		Host guest = new Host();
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			guest.addOffer(offer);
			assertEquals(1, guest.getOffers().size());
			guest.removeOffer(offer);
			assertEquals(0, guest.getOffers().size());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testRemoveHouse() {
		Host guest = new Host();
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		guest.addHouse(house);
		assertEquals(1, guest.getHouses().size());
		guest.removeHouse(house);
		assertEquals(0, guest.getHouses().size());
	}

	@Test
	public void testIsHost() {
		assertTrue(new Host().isHost());
	}

	@Test
	public void testHost() {
		assertNotNull(new Host());
	}

}
